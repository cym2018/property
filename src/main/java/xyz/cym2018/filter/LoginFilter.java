package xyz.cym2018.filter;

import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/admin/*", "/visit/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            Login login = (Login) request.getSession().getAttribute("login");
        } catch (Exception e) {
            response.sendRedirect("/login.html?message=login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
