package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {
    final static Logger logger = LogManager.getLogger(AdminController.class);
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    HttpServletResponse httpResponse;
    @Autowired
    LoginRepository loginRepository;

    // 登陆
    @RequestMapping("/login")
    public boolean Login(Login login) {
        try {
            if (login.Valid()) {
                Optional<Login> ret = loginRepository.findOne(Example.of(login));//.get();
                if (!ret.isPresent()) {
                    throw new Exception("登陆失败");
                }
                login = ret.get();
                httpRequest.getSession().setAttribute("login", login);
                Cookie cookie = new Cookie("username", login.getUsername());
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
                cookie = new Cookie("isAdmin", login.getId() == 1 ? "true" : "false");
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
                logger.info("success");
                return true;
            }
        } catch (Exception e) {
            logger.warn(e.toString());
        }
        logger.info("fail");
        return false;
    }

    @RequestMapping("/logout")
    public boolean Logout() {
        httpRequest.getSession().removeAttribute("login");
        Cookie[] cookies = httpRequest.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            httpResponse.addCookie(cookie);
        }
        return true;
    }

    @RequestMapping("/permissionError")
    public String PermissionError() {
        return "操作失败:权限不足!";
    }
}
