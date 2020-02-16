package xyz.cym2018.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "permissionsFilter", urlPatterns = "/admin/*")
public class PermissionFilter implements Filter {
    final static Logger logger = LogManager.getLogger(PermissionFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            Login login = (Login) request.getSession().getAttribute("login");
            if (login.getId() != 1) {
                throw new Exception();
            }
            logger.info("合法访问");
        } catch (Exception e) {
            response.sendRedirect("/public/permissionError");
            logger.info("权限不足");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
