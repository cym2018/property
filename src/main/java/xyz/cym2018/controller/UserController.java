package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.User;
import xyz.cym2018.DAO.UserRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 使空值为null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // 处理时间格式,允许时间空值
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/query")
    public String Query(User user, Integer pageSize, Integer pageNumber) {
        pageSize++;
        try {
            if (pageSize != null) {
                Page page = userRepository.findAll(Example.of(user), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page);
            } else {
                user = userRepository.findById(user.getId()).get();
                return objectMapper.writeValueAsString(user);
            }
        } catch (Exception e) {
            System.out.println("x.c.c.UserController.Query:ERROR!\n" + e.toString());
            return "";
        }
    }
    @RequestMapping("/queryList")
    public String QueryList(User user, Integer pageSize, Integer pageNumber) {
        pageSize++;
        try {
            if (pageSize != null) {
                Page page = userRepository.findAll(Example.of(user), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page.toList());
            } else {
                user = userRepository.findById(user.getId()).get();
                return objectMapper.writeValueAsString(user);
            }
        } catch (Exception e) {
            System.out.println("x.c.c.UserController.Query:ERROR!\n" + e.toString());
            return "";
        }
    }
    @RequestMapping("/save")
    public String Save(User user) {
        try {
            userRepository.save(user);
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!\n" + e.toString();
        }
    }
    @RequestMapping("/between")
    public String Between(Date startDate,Date endDate,Integer pageNumber,Integer pageSize) throws JsonProcessingException {
        Page page=userRepository.findByPaidForTimeBetween(startDate,endDate,
                PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
        return objectMapper.writeValueAsString(page);
    }
    @RequestMapping("/myQuery")
    public  String MyQuery() throws JsonProcessingException {
        List page=userRepository.MyQuery();
        return objectMapper.writeValueAsString(page);
    }
    @RequestMapping("/myPage")
    public String MyPage() throws JsonProcessingException {
        List page=userRepository.MyPage(PageRequest.of(0,10));
        return objectMapper.writeValueAsString(page);
    }
}
