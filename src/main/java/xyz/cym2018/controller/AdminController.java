package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.LoginRepository;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table1Repository;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    final static Logger logger = LogManager.getLogger(AdminController.class);
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    Table1Repository table1Repository;

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

    @RequestMapping("/table1/save")
    public String Save(Table1 table1) {
        try {
            table1Repository.save(table1);
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!\n" + e.toString();
        }
    }
}
