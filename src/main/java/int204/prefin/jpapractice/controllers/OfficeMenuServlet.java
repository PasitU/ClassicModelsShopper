package int204.prefin.jpapractice.controllers;


import int204.prefin.jpapractice.models.entities.Office;
import int204.prefin.jpapractice.models.repositories.OfficeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OfficeMenuServlet", value = "/OfficeMenu")
public class OfficeMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository or = new OfficeRepository();
        List<Office> allOffices = or.getAllOffices();
        String error = request.getParameter("error");
        request.setAttribute("officeList", allOffices);
        request.setAttribute("error", error);
        if(request.getParameter("officeCode") != null){
            request.setAttribute("empList",or.getEmployees(request.getParameter("officeCode")));
        }
        request.getRequestDispatcher("WEB-INF/OfficeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository or = new OfficeRepository();
        List<Office> allOffices = or.getAllOffices();
        String error = (String) request.getAttribute("error");
        System.out.println(error);
        request.setAttribute("officeList", allOffices);
        request.setAttribute("error", error);
        request.getRequestDispatcher("WEB-INF/OfficeList.jsp").forward(request, response);
    }
}