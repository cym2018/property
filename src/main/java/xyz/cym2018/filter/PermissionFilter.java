package xyz.cym2018.filter;

import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "permissionsFilter", urlPatterns = {"/login/save", "/save","/login/list"})
public class PermissionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("PermissionFilter 被调用");
        try {
            Login login = (Login) request.getSession().getAttribute("login");
            if(login.getId()!=1){
                Exception e=new Exception();
                throw e;
            }
        }catch (Exception e){
            response.sendRedirect("/permissionError.html");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
