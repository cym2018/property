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
import xyz.cym2018.DAO.Login;
import xyz.cym2018.DAO.Owner;
import xyz.cym2018.DAO.OwnerRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController {
    /*
        /visit/table1/query
        /visit/table1/save
        /visit/info
     */
    @Autowired
    OwnerRepository ownerRepository;
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


}
