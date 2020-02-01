package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    ObjectMapper objectMapper;

    // 登陆
    @RequestMapping("/login")
    public String Login(Login login) throws JsonProcessingException {
        login = loginService.getLogin(login);
        if (login != null) {
            httpRequest.getSession().setAttribute("login", login);
            return objectMapper.writeValueAsString(login);
        }
        return "false";
    }
}
