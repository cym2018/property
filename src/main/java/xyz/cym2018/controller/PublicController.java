package xyz.cym2018.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Login;

import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController extends template {

    final static Logger logger = LogManager.getLogger(AdminController.class);

    // 登陆
    @RequestMapping("/login")
    public boolean Login(Login login) {
        try {
            Optional<Login> ret = loginRepository.findOne(Example.of(login));
            login = ret.get();
        } catch (Exception e) {
            logger.info("fail");
            return false;
        }
        sessionOperate.setLogin(login);
        cookieOperate.CreateCookie("username", login.getUsername())
                .CreateCookie("isAdmin", login.getId() == 1 ? "true" : "false");
        logger.info("success");
        return true;
    }

    @RequestMapping("/logout")
    public boolean Logout() {
        sessionOperate.removeAllValues();
        cookieOperate.RemoveAllCookies();
        return true;
    }

    @RequestMapping("/permissionError")
    public String PermissionError() {
        return "操作失败:权限不足!";
    }

    @RequestMapping("/refresh")
    public boolean Refresh() {
        Login login;
        try {
            login = sessionOperate.getLogin();
        } catch (Exception e) {
            return false;
        }
        cookieOperate.CreateCookie("username", login.getUsername())
                .CreateCookie("isAdmin", login.getId() == 1 ? "true" : "false");
        return true;
    }
}