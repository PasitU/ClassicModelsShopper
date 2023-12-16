package int204.prefin.jpapractice.controllers;


import int204.prefin.jpapractice.models.repositories.OfficeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteOfficeServlet", value = "/DeleteOffice")
public class DeleteOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository or = new OfficeRepository();
        String officeCode = request.getParameter("deleteCode");
        if(or.deleteOffice(officeCode)) {
            request.setAttribute("message", "Office with code " + officeCode + " was successfully deleted");
        }else{
            request.setAttribute("error", "There was an error deleting the office, please try again later");
        }
        request.getRequestDispatcher("OfficeMenu").forward(request, response);
    }

}