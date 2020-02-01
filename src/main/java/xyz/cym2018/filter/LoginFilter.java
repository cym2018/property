package xyz.cym2018.filter;

import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/user/*", "/owner/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("loginFilter 被调用");
        try {
            Login login = (Login) request.getSession().getAttribute("login");
            System.out.println(login.toString());
        }catch (Exception e){
            response.sendRedirect("/login.html?message=login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
