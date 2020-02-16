package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Table1;
import xyz.cym2018.DAO.Table2;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController extends template {
    final static Logger logger = LogManager.getLogger(VisitController.class);


    @RequestMapping("/table1/query")
    public String Table1Query(Table1 table1, Integer pageSize, Integer pageNumber) {
        try {
            if (pageNumber != null) {
                logger.info(table1.toString());
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
            return objectMapper.writeValueAsString(table1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table1/counts")
    public String Table1Count(Table1 table1) throws JsonProcessingException {
        int countPaidForTime = 0, countBreaks = 0, countPaidAt51 = 0, countDepsit = 0, countDepositToCost = 0, countRefundNumber = 0,
                countProperty1 = 0, countProperty2 = 0, countProperty3 = 0, countNumberNote = 0, countArea = 0, countTextNote = 0;
        Table1 ret = new Table1();
        List<Table1> list = table1Repository.findAll(Example.of(table1));
        for (Table1 i : list) {
            if (i.getBreaks() != null) countBreaks++;
            if (i.getPaidAt51() != null) countPaidAt51++;
            if (i.getDepsit() != null) countDepsit++;
            if (i.getDepositToCost() != null) countDepositToCost++;
            if (i.getRefundNumber() != null) countRefundNumber++;
            if (i.getProperty1() != null) countProperty1++;
            if (i.getProperty2() != null) countProperty2++;
            if (i.getProperty3() != null) countProperty3++;
            if (i.getNumberNote() != null) countNumberNote++;
            if (i.getTextNote() != null) countTextNote++;
        }
        ret.setBreaks((double) countBreaks);
        ret.setPaidAt51((double) countPaidAt51);
        ret.setDepsit(String.valueOf(countDepsit));
        ret.setDepositToCost((double) countDepositToCost);
        ret.setRefundNumber((double) countRefundNumber);
        ret.setProperty1((double) countProperty1);
        ret.setProperty2((double) countProperty2);
        ret.setProperty3((double) countProperty3);
        ret.setNumberNote((double) countNumberNote);
        ret.setTextNote(String.valueOf(countTextNote));
        return objectMapper.writeValueAsString(ret);
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
        // select distinct name from table2
        try {
            List<Table2> list = table2Repository.findAll(Example.of(table2));
            table2.Clear();
            for (Table2 i : list) {
                table2.Add(i);
            }
            return objectMapper.writeValueAsString(table2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table2/counts")
    public String Table2Count(Table2 table2) throws JsonProcessingException {
        int countRefundNumber = 0, countProperty1 = 0, countProperty2 = 0, countProperty3 = 0, countNumberNote = 0, countArea = 0, countGarbage = 0, countTextNote = 0, countDepositState = 0;
        Table2 ret = new Table2();
        List<Table2> list = table2Repository.findAll(Example.of(table2));
        for (Table2 i : list) {
            if (i.getRefundNumber() != null) countRefundNumber++;
            if (i.getGarbage() != null) countGarbage++;
            if (i.getProperty1() != null) countProperty1++;
            if (i.getProperty2() != null) countProperty2++;
            if (i.getProperty3() != null) countProperty3++;
            if (i.getNumberNote() != null) countNumberNote++;
            if (i.getTextNote() != null) countTextNote++;
            if (i.getDepositState() != null) countDepositState++;
        }
        ret.setRefundNumber((double) countRefundNumber);
        ret.setGarbage((double) countGarbage);
        ret.setProperty1((double) countProperty1);
        ret.setProperty2((double) countProperty2);
        ret.setProperty3((double) countProperty3);
        ret.setNumberNote((double) countNumberNote);
        ret.setTextNote(String.valueOf(countTextNote));
        ret.setDepositState(String.valueOf(countDepositState));
        return objectMapper.writeValueAsString(ret);
    }
}
