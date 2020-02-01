package xyz.cym2018.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Page findByPaidForTimeBetween(Date paidForTime, Date paidForTime2, Pageable var2);

    @Query("from User")
    public List MyQuery();

    @Query(value = "from User")
    public List MyPage(Pageable pageable);
}
