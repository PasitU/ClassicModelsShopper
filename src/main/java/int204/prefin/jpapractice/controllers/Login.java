package int204.prefin.jpapractice.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
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
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("user", username);
                response.sendRedirect("index.jsp");
            }
        }
    }
}