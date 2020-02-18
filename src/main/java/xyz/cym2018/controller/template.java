package xyz.cym2018.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import xyz.cym2018.DAO.LoginRepository;
import xyz.cym2018.DAO.Table1Repository;
import xyz.cym2018.DAO.Table2Repository;
import xyz.cym2018.DAO.Table3Repository;
import xyz.cym2018.tools.CookieOperate;
import xyz.cym2018.tools.SessionOperate;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@CrossOrigin(origins = "*")
public class template {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    Table1Repository table1Repository;
    @Autowired
    Table2Repository table2Repository;
    @Autowired
    Table3Repository table3Repository;
    @Autowired
    SessionOperate sessionOperate;
    @Autowired
    CookieOperate cookieOperate;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 使空值为null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // 处理时间格式,允许时间空值
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }

}
