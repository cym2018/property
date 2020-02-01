package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginRepository;
import xyz.cym2018.DAO.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    /*
        /admin/query
        /admin/save
     */
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LoginRepository loginRepository;

    @RequestMapping("/list")
    public String List() throws JsonProcessingException {
        List<Login> list = loginRepository.findAll();
        return objectMapper.writeValueAsString(list);
    }

    @RequestMapping("/save")
    public Boolean Info(Login login) {
        try {
            if (login.Valid()) {
                loginRepository.save(login);
                return true;
            }
        } catch (DataIntegrityViolationException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/query")
    public String Query(Login login) throws JsonProcessingException {
        login = loginRepository.getOne(login.getId());
        return objectMapper.writeValueAsString(login);
    }
}
