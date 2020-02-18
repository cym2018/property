package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table2;
import xyz.cym2018.DAO.Table3;
import xyz.cym2018.tools.MyPage;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends template {
    @RequestMapping("/query1")
    public String Table1Query(Login login) throws JsonProcessingException {
        List<Login> list;
        // 获得Example筛选结果
        list = loginRepository.findAll(Example.of(login));
        System.out.println(login.toString());
        list.forEach(o -> System.out.println(o.toString()));
        return objectMapper.writeValueAsString(new MyPage<>(list, null, null, null, null));
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

    @RequestMapping("/table1/save")
    public Boolean Table1Save(Table1 table1) {
        try {
            System.out.println(table1.toString());
            table1Repository.save(table1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/table2/save")
    public Boolean Table2Save(Table2 table2) {
        try {
            System.out.println(table2.toString());
            table2Repository.save(table2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @RequestMapping("/table3/save")
    public Boolean Table3Save(Table3 table3) {
        try {
            System.out.println(table3.toString());
            table3Repository.save(table3);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
