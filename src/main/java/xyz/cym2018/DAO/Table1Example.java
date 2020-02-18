package xyz.cym2018.DAO;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.Repository;
import org.springframework.data.util.Streamable;

import java.sql.Date;

public interface Table1Example extends Repository<Table1, Integer> {
    Streamable<Table1> findAll(Example<Table1> var1);

    Streamable<Table1> findByPaidForTimeIsAfter(Date date);

    Streamable<Table1> findByPaidForTimeIsBefore(Date date);

    Streamable<Table1> findByNameIsContaining(String var1);

    Streamable<Table1> findByBuildingNumberLessThan(Integer num);

}