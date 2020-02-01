package xyz.cym2018.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecodeRepository extends JpaRepository<Recode,Integer> {
    public List<Recode> findByUserId(Integer userId);
}
