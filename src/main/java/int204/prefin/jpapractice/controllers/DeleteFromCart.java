package int204.prefin.jpapractice.controllers;

import int204.prefin.jpapractice.models.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeleteFromCart", value = "/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String productCode = request.getParameter("productCode");
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeItem(productCode);
        request.getRequestDispatcher("ViewCart").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}