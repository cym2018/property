package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table2;
import xyz.cym2018.DAO.Table3;
import xyz.cym2018.tools.MyPage;

import java.sql.Date;
import java.util.List;


// 1. 根据selectForm获取符合条件的条目
// 2. 筛选时间
// 3. 排序
@RestController
@RequestMapping("/visit")
public class VisitController extends template {
    private int pageSize;
    private final static Logger logger = LogManager.getLogger(VisitController.class);
    private Sort sort;

    public VisitController() {
        pageSize = 20;
        sort = Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber");
    }


    @RequestMapping("/set")
    public void set(Integer pageSize) {

        if (pageSize != null)
            this.pageSize = pageSize;
    }

    @RequestMapping("/table1/query1")
    public String Table1Query(Table1 table1, Date startDate, Date endDate, Integer pageNumber) throws JsonProcessingException {
        // 获得Example筛选结果
        List<Table1> list = table1Repository.findAll(Example.of(table1), sort);
        // 获得日期筛选结果
        if (startDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().before(startDate);
            });
        }
        if (endDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().after(endDate);
            });
        }
        Table1 counts = new Table1(), statistics = new Table1();
        counts.setName("非空行数");
        counts.Clear();
        statistics.setName("求和");
        statistics.Clear();
        list.forEach(statistics::Statistics);
        list.forEach(counts::Counts);
        return objectMapper.writeValueAsString(new MyPage<>(list, pageSize, pageNumber, statistics, counts));
    }

    @RequestMapping("/table2/query1")
    public String Table2Query(Table2 table2, Date startDate, Date endDate, Integer pageNumber) throws JsonProcessingException {
        Table2 counts = new Table2(), statistics = new Table2();
        List<Table2> list;
        // 获得Example筛选结果
        list = table2Repository.findAll(Example.of(table2), sort);
        // 获得日期筛选结果
        if (startDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().before(startDate);
            });
        }
        if (endDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().after(endDate);
            });
        }
        counts.setName("非空行数");
        counts.Clear();
        statistics.setName("求和");
        statistics.Clear();
        list.forEach(statistics::Statistics);
        list.forEach(counts::Counts);
        return objectMapper.writeValueAsString(new MyPage<>(list, pageSize, pageNumber, statistics, counts));
    }

    @RequestMapping("/table3/query1")
    public String Table3Query(Table3 table3, Date startDate, Date endDate, Integer pageNumber) throws JsonProcessingException {
        Table3 counts = new Table3(), statistics = new Table3();
        List<Table3> list;
        // 获得Example筛选结果
        list = table3Repository.findAll(Example.of(table3), sort);
        // 获得日期筛选结果
        if (startDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().before(startDate);
            });
        }
        if (endDate != null) {
            list.removeIf(o -> {
                if (o.getPaidForTime() == null)
                    return true;
                return o.getPaidForTime().after(endDate);
            });
        }
        counts.setName("非空行数");
        counts.Clear();
        statistics.setName("求和");
        statistics.Clear();
        list.forEach(statistics::Statistics);
        list.forEach(counts::Counts);
        return objectMapper.writeValueAsString(new MyPage<>(list, pageSize, pageNumber, statistics, counts));
    }
}
