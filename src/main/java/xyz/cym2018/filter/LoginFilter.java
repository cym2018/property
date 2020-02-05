package xyz.cym2018.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.cym2018.DAO.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/admin/*", "/visit/*"})
public class LoginFilter implements Filter {
    final static Logger logger = LogManager.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            Login login = (Login) request.getSession().getAttribute("login");
            logger.info(login.toString());
        } catch (Exception e) {
            logger.info("获取登陆信息失败");
            response.sendRedirect("/login.html?message=login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
