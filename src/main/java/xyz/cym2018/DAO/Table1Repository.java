package xyz.cym2018.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Table1Repository extends JpaRepository<Table1, Integer> {


    Optional<Table1> findById(Integer id);

}
