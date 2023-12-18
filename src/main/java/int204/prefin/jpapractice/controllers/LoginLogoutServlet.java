package int204.prefin.jpapractice.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import int204.prefin.jpapractice.models.entities.Customer;
import int204.prefin.jpapractice.models.repositories.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class LoginLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if(user != null){
            session.removeAttribute("user");
            response.sendRedirect("index.jsp");
        }
        else
        {
            String username = request.getParameter("user");
            String password = request.getParameter("password");
            boolean usrValid = false;
            boolean passwordValid = false;
            if (username != null && !username.isEmpty()) {
                usrValid = true;
            }
            if (password != null && !password.isEmpty()) {
                passwordValid = true;
            }
            if (!usrValid || !passwordValid) {
                request.setAttribute("error", "Username or Password can't be empty!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                CustomerRepository cr = new CustomerRepository();
                Customer loggee = cr.getByName(username);
                if(loggee == null){
                    request.setAttribute("error", "No such user exists in our database");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d,16,16);
                boolean correctPass = argon2.verify(loggee.getPassword(), password);
                if(!correctPass){
                    request.setAttribute("error", "Incorrect Password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                session.setAttribute("user", username);
                response.sendRedirect("index.jsp");
            }
        }
    }
}