package xyz.cym2018.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    private boolean isFull(Login login) {
        return login.getUsername() != null && login.getPassword() != null;
    }

    private boolean isUsernameExist(Login login) {
        return loginRepository.findFirstByUsername(login.getUsername()) != null;
    }

    public Login getLogin(Login login) {
        // 排除信息不全的情况
        if (!isFull(login)) {
            return null;
        }
        List<Login> list = loginRepository.findAll(Example.of(login));
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public Login register(Login login) {
        if (!isFull(login)) {
            return null;
        }
        if (isUsernameExist(login)) {
            return null;
        }
        login = loginRepository.save(login);
        System.out.println(login.toString());
        return login;
    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    public Login findById(Login login) {
        return loginRepository.findById(login.getId()).get();
    }

    public boolean Update(Login login) {
        if (login.getId() != null && isFull(login)) {
            loginRepository.save(login);
            return true;
        }
        return false;
    }
}
