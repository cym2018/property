package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table1Example;

import java.sql.Date;
import java.util.Calendar;
import java.util.function.Predicate;

//import java.util.Date;


@RequestMapping("/test")
@RestController
public class TestController{
    final Table1Example table1Example;
    final ObjectMapper objectMapper;

    public TestController(Table1Example table1Example, ObjectMapper objectMapper) {
        this.table1Example = table1Example;
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/t1")
    public String T1() {
        return "test";
    }

    @RequestMapping("/t2")
    public String T2(int year1, int month1, int year2, int month2) throws JsonProcessingException {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year1, month1, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(year2, month2, 1);
        Streamable<Table1> table1s = table1Example.findByPaidForTimeIsAfter(new Date(calendar1.getTimeInMillis()));
//                .filter(table1Example.findByPaidForTimeIsBefore(new Date(calendar2.getTimeInMillis())));

        Predicate<Date> predicate = new Predicate<Date>() {
            @Override
            public boolean test(Date date) {
                return false;
            }
        };
        return objectMapper.writeValueAsString(table1s.toList());

    }

}
