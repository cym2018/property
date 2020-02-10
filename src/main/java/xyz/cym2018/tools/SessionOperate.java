package xyz.cym2018.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.cym2018.DAO.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Component
public class SessionOperate {
    @Autowired
    HttpServletRequest httpRequest;
    @Autowired
    HttpServletResponse httpResponse;
    @Autowired
    HttpSession httpSession;

    public SessionOperate setLogin(Login login) {
        httpSession.setAttribute("login", login);
        return this;
    }

    public Login getLogin() {
        return (Login) httpSession.getAttribute("login");
    }

    public SessionOperate removeAllValues() {
        Enumeration<String> sessions = httpSession.getAttributeNames();
        while (sessions.hasMoreElements()) {
            httpSession.removeAttribute(sessions.nextElement());
        }
        return this;
    }
}
