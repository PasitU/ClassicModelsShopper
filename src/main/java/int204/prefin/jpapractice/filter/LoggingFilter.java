package int204.prefin.jpapractice.filter;


import com.mysql.cj.ServerPreparedQuery;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(filterName = "LoggingFilter", servletNames = {"ProductListServlet","ViewCartServlet"})
public class LoggingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        if(request1.getSession() == null || request1.getSession().getAttribute("user") == null){
            response1.sendRedirect("login.jsp");
        }else {
            chain.doFilter(request, response);
        }
    }
}