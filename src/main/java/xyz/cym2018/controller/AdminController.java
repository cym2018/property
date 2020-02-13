package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table2;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController extends template {
    @RequestMapping("/query")
    public String Table1Query(Login login, Integer pageSize, Integer pageNumber) {
        try {
            if (pageNumber != null) {
                Page<Login> page = loginRepository.findAll(PageRequest.of(pageNumber, pageSize));
                return objectMapper.writeValueAsString(page);
            } else {
                Optional<Login> ret = loginRepository.findById(login.getId());
                if (!ret.isPresent()) {
                    throw new Exception("无符合条件的记录");
                }
                login = ret.get();
                return objectMapper.writeValueAsString(login);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }




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

    @RequestMapping("/query1")
    public String LoginQuery(Login login) throws JsonProcessingException {
        login = loginRepository.getOne(login.getId());
        return objectMapper.writeValueAsString(login);
    }

    @RequestMapping("/table1/save")
    public Boolean Table1Save(Table1 table1) {
        try {
            table1Repository.save(table1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/table2/save")
    public Boolean Table2Save(Table2 table2) {
        try {
            table2Repository.save(table2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
