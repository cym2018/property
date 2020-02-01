package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/login")
    public String Login(Login login) throws JsonProcessingException {
        login = loginService.getLogin(login);
        if (login != null) {
            httpRequest.getSession().setAttribute("login", login);
            return objectMapper.writeValueAsString(login);
        }
        return "false";
    }

    @RequestMapping("/info")
    public String Info() throws JsonProcessingException {
        Login login = (Login) httpRequest.getSession().getAttribute("login");
        return objectMapper.writeValueAsString(login);
    }

    @RequestMapping("/save")
    public String Info(Login login) throws JsonProcessingException {
        try {
            if (login.getId() == null) {
                login = loginService.register(login);
                objectMapper.writeValueAsString(login);
            } else {
                loginService.Update(login);
            }
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    @RequestMapping("/list")
    public String List() throws JsonProcessingException {
        List list = loginService.getLoginRepository().findAll();
        return objectMapper.writeValueAsString(list);
    }

    @RequestMapping("/queryById")
    public String QueryByIdd(Login login) throws JsonProcessingException {
        login = loginService.findById(login);
        return objectMapper.writeValueAsString(login);
    }
}
