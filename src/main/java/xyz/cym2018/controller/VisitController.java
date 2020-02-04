package xyz.cym2018.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController {
    /*
        /visit/table1/query
        /visit/table1/save
        /visit/table2/query
        /visit/table2/save
        /visit/info
     */
    @Autowired
    OwnerRepository ownerRepository;
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
    public String Query(Owner owner, Integer pageSize, Integer pageNumber) {
        try {
            if (pageNumber != null) {
                Page<Owner> page = ownerRepository.findAll(Example.of(owner), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page);
            } else {
                Optional<Owner> ret = ownerRepository.findById(owner.getId());
                if (!ret.isPresent()) {
                    throw new Exception("无符合条件的记录");
                }
                owner = ret.get();
                return objectMapper.writeValueAsString(owner);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table1/statistics")
    public String Statistics(Owner owner) {
        try {
            List<Owner> list = ownerRepository.findAll(Example.of(owner));
            owner.Clear();
            for (Owner i : list) {
                owner.Add(i);
            }
            return objectMapper.writeValueAsString(owner);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping("/table2/query")
    public String Table2Query(Table2 table2, Integer pageSize, Integer pageNumber){
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
            return objectMapper.writeValueAsString(table2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
