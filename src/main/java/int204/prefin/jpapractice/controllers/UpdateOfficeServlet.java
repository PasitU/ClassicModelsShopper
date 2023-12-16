package int204.prefin.jpapractice.controllers;

import int204.prefin.jpapractice.models.entities.Office;
import int204.prefin.jpapractice.models.repositories.OfficeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateOfficeServlet", value = "/UpdateOffice")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository or = new OfficeRepository();
        String targetOfficeCode = request.getParameter("officeCode");
        Office officeToUp = or.getOffice(targetOfficeCode);
        if (officeToUp == null) {
            request.setAttribute("error", "error find an office with code: " + targetOfficeCode);
            request.getRequestDispatcher("OfficeMenu").forward(request, response);
        }
        request.setAttribute("officeToUp", officeToUp);
        request.getRequestDispatcher("WEB-INF/UpdateOffice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> paramMap = request.getParameterMap();
        OfficeRepository or = new OfficeRepository();
        String targetOfficeCode = request.getParameter("officeCode");
        Office officeToUp = or.getOffice(targetOfficeCode);
        String newCity = paramMap.get("newCity")[0];
        String newPhone = paramMap.get("newPhone")[0];
        String newAddressLine1 = paramMap.get("newAddressLine1")[0];
        String newAddressLine2 = paramMap.get("newAddressLine2")[0];
        String newState = paramMap.get("newState")[0];
        String newCountry = paramMap.get("newCountry")[0];
        String newPostalCode = paramMap.get("newPostalCode")[0];
        String newTerritory = paramMap.get("newTerritory")[0];
        List<String> errors = new ArrayList<>();
        if (newCity == null || newCity.isEmpty() || newCity.isBlank()) {
            errors.add("City can't be empty");
        }
        if (newPhone == null || newPhone.isEmpty() || newPhone.isBlank()) {
            errors.add("Phone can't be empty");
        }
        if (newAddressLine1 == null || newAddressLine1.isEmpty() || newAddressLine1.isBlank()) {
            errors.add("AddressLine1 can't be empty");
        }
        if (newCountry == null || newCountry.isEmpty() || newCountry.isBlank()) {
            errors.add("Country can't be empty");
        }
        if (newPostalCode == null || newPostalCode.isEmpty() || newPostalCode.isBlank()) {
            errors.add("PostalCode can't be empty");
        }
        if (newTerritory == null || newTerritory.isEmpty() || newTerritory.isBlank()) {
            errors.add("Territory can't be empty");
        }

        if (!errors.isEmpty()) {
            List<String> lastInputs = new ArrayList<>();
            lastInputs.add(newCity);
            lastInputs.add(newPhone);
            lastInputs.add(newAddressLine1);
            lastInputs.add(newAddressLine2);
            lastInputs.add(newState);
            lastInputs.add(newCountry);
            lastInputs.add(newPostalCode);
            lastInputs.add(newTerritory);
            request.setAttribute("errors", errors);
            request.setAttribute("badInputs", lastInputs);
            request.setAttribute("officeToUp", officeToUp);
            request.getRequestDispatcher("WEB-INF/UpdateOffice.jsp").forward(request, response);
        } else {
            Office o = new Office(targetOfficeCode, newCity, newPhone, newAddressLine1, newAddressLine2, newState, newCountry, newPostalCode, newTerritory, null);
            if (or.updateOffice(o)) {
                request.setAttribute("message", "Update successful");

            } else {
                errors.add("Error unable to update, please try again");
                request.setAttribute("errors", errors);
            }
            request.setAttribute("officeToUp", officeToUp);
            request.getRequestDispatcher("WEB-INF/UpdateOffice.jsp").forward(request, response);
        }
    }
}