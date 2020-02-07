package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import xyz.cym2018.DAO.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 使空值为null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // 处理时间格式,允许时间空值
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    final static Logger logger = LogManager.getLogger(VisitController.class);
    @Autowired
    Table1Repository table1Repository;
    @Autowired
    Table2Repository table2Repository;
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/info")
    public String Info() throws JsonProcessingException {
        Login login = (Login) httpRequest.getSession().getAttribute("login");
        return objectMapper.writeValueAsString(login);
    }

    @RequestMapping("/table1/query")
    public String Table1Query(Table1 table1, Integer pageSize, Integer pageNumber) {
        try {
            if (pageNumber != null) {
                Page<Table1> page = table1Repository.findAll(Example.of(table1), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page);
            } else {
                Optional<Table1> ret = table1Repository.findById(table1.getId());
                if (!ret.isPresent()) {
                    throw new Exception("无符合条件的记录");
                }
                table1 = ret.get();
                return objectMapper.writeValueAsString(table1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table1/statistics")
    public String Table1Statistics(Table1 table1) {
        try {
            List<Table1> list = table1Repository.findAll(Example.of(table1));
            table1.Clear();
            for (Table1 i : list) {
                table1.Add(i);
            }
            table1.Rounded();
            System.out.println(table1.toString());
            return objectMapper.writeValueAsString(table1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table2/query")
    public String Table2Query(Table2 table2, Integer pageSize, Integer pageNumber) {
        try {
            if (pageNumber != null) {
                Page<Table2> page = table2Repository.findAll(Example.of(table2), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page);
            } else {
                Optional<Table2> ret = table2Repository.findById(table2.getId());
                if (!ret.isPresent()) {
                    throw new Exception("无符合条件的记录");
                }
                table2 = ret.get();
                return objectMapper.writeValueAsString(table2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table2/statistics")
    public String Table2Statistics(Table2 table2) {
        try {
            List<Table2> list = table2Repository.findAll(Example.of(table2));
            table2.Clear();
            for (Table2 i : list) {
                table2.Add(i);
            }
            table2.Rounded();
            return objectMapper.writeValueAsString(table2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
