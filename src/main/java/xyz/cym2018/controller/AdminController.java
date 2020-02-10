package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table2;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends template {
    @RequestMapping("/list")
    public String LoginList() throws JsonProcessingException {
        List<Login> list = loginRepository.findAll();
        return objectMapper.writeValueAsString(list);
    }

    @RequestMapping("/save")
    public Boolean LoginSave(Login login) {
        try {
                loginRepository.save(login);
                return true;
        } catch (DataIntegrityViolationException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/query")
    public String LoginQuery(Login login) throws JsonProcessingException {
        login = loginRepository.getOne(login.getId());
        return objectMapper.writeValueAsString(login);
    }

    @RequestMapping("/table1/save")
    public String Table1Save(Table1 table1) {
        try {
            table1Repository.save(table1);
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!\n" + e.toString();
        }
    }

    @RequestMapping("/table2/save")
    public String Table2Save(Table2 table2) {
        try {
            table2Repository.save(table2);
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!\n" + e.toString();
        }
    }
}
