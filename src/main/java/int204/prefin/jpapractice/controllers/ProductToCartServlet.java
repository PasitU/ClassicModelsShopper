package int204.prefin.jpapractice.controllers;

import int204.prefin.jpapractice.models.Cart;
import int204.prefin.jpapractice.models.CartItem;
import int204.prefin.jpapractice.models.entities.Product;
import int204.prefin.jpapractice.models.repositories.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ProductToCartServlet", value = "/AddProduct")
public class ProductToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductRepository pr = new ProductRepository();
        String productCode = request.getParameter("productCode");
        Product product2Add = pr.findProduct(productCode);
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
        }
        cart.addItem(product2Add.getProductCode(), new CartItem(product2Add, 1));
        session.setAttribute("cart", cart);
        String size = request.getParameter("size");
        String page = request.getParameter("page");
        int pageNum = 1;
        if(page != null){
            pageNum = Integer.parseInt(page);
        }
        int sizeNum = pr.DEFAULT_SIZE;
        if(size != null){
            sizeNum = Integer.parseInt(size);
        }
        request.setAttribute("totalPage", pr.getTotalPages()/sizeNum + (pr.getTotalPages()%sizeNum != 0 ? 1 : 0));
        request.setAttribute("productList", pr.getProductByPage(pageNum, sizeNum));
        request.setAttribute("currentPage", pageNum);
        request.setAttribute("currentSize", sizeNum);
        request.getRequestDispatcher("WEB-INF/ProductList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}