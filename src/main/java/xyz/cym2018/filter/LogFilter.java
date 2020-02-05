package xyz.cym2018.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "logFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {
    final static Logger logger = LogManager.getLogger(LogFilter.class);

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info(request.getRemoteAddr() + ":" + request.getRequestURI()+":"+request.getQueryString());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
