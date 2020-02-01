package xyz.cym2018.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "login", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer permissions;

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                '}';
    }
    public boolean Valid(){
        return username != null && password != null;
    }
}
