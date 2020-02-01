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
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    ObjectMapper objectMapper;
    @RequestMapping("/info")
    public String Info() throws JsonProcessingException {
        Login login = (Login) httpRequest.getSession().getAttribute("login");
        return objectMapper.writeValueAsString(login);
    }

    
}
