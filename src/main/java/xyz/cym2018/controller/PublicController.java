package xyz.cym2018.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginRepository;
import xyz.cym2018.DAO.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {
    /*
        /public/login
     */
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    HttpServletResponse httpResponse;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LoginRepository loginRepository;

    // 登陆
    @RequestMapping("/login")
    public boolean Login(Login login) {
        System.out.println("/public/login");
        try {
            if (login.Valid()) {
                Optional<Login> ret = loginRepository.findOne(Example.of(login));//.get();
                if (!ret.isPresent()) {
                    throw new Exception("登陆失败");
                }
                httpRequest.getSession().setAttribute("login", login);
                Cookie cookie = new Cookie("username", login.getUsername());
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
                cookie = new Cookie("isAdmin", login.getId() == 1 ? "true" : "false");
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
