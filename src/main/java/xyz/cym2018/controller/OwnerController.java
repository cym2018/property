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
import xyz.cym2018.DAO.Owner;
import xyz.cym2018.DAO.OwnerRepository;

import java.util.Optional;


@RestController
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    ObjectMapper objectMapper;


    @RequestMapping("/query")
    public String Query(Owner owner, Integer pageSize, Integer pageNumber) {
        if (pageSize != null) pageSize++;
        try {
            if (pageSize != null) {
                Page page = ownerRepository.findAll(Example.of(owner), PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "buildingNumber", "unitNumber", "roomNumber")));
                return objectMapper.writeValueAsString(page);
            } else {
                owner = ownerRepository.findById(owner.getId()).get();
                return objectMapper.writeValueAsString(owner);
            }
        } catch (Exception e) {
            System.out.println("x.c.c.mainController.Query:ERROR!\n" + e.toString());
            return "";
        }

    }

    @RequestMapping("/queryById")
    public String QueryById(Integer id) throws JsonProcessingException {
        Optional op = ownerRepository.findById(id);
        return (op.toString());
    }

    @RequestMapping("/save")
    public String Save(Owner owner) {
        try {
            ownerRepository.save(owner);
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!\n" + e.toString();
        }
    }
}
