package xyz.cym2018.filter;

import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "permissionsFilter", urlPatterns = {"/admin/*", "/visit/table1/edit*"})
public class PermissionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            Login login = (Login) request.getSession().getAttribute("login");
            if (login.getId() != 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            response.sendRedirect("/public/permissionError");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
