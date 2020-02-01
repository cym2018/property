package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Recode;
import xyz.cym2018.DAO.RecodeRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/recode")
public class RecodeController {
    @Autowired
    RecodeRepository recodeRepository;
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
    public String Query(Recode recode) throws JsonProcessingException {
        List<Recode> ret = recodeRepository.findAll(Example.of(recode), Sort.by(Sort.Direction.ASC, "date", "title"));
        return objectMapper.writeValueAsString(ret);
    }

    @RequestMapping("/create")
    public String Create(Recode recode) {
        if (recode.getDate() == null) {
            recode.setDate(new Date(System.currentTimeMillis()));
        }
        recode = recodeRepository.save(recode);
        if (recode.getId() == null) return "操作失败!";
        return "操作成功!";
    }

}
