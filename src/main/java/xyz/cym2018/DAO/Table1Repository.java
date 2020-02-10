package xyz.cym2018.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Table1Repository extends JpaRepository<Table1, Integer> {
    Integer countAllByDepositToCostIsNotNull();

    Integer countAllByPaidForTimeIsNotNull();

    Integer countAllByWechatPayIsNotNull();

    Integer countAllByMoneyPayIsNotNull();

    Integer countAllByUnionPayIsNotNull();

    Integer countAllByrefundNumberIsNotNull();

    Integer countAllBybreaksIsNotNull();
}
