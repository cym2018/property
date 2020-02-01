package xyz.cym2018.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    public Login findFirstByUsername(String username);
}
