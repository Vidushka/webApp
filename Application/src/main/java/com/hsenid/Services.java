package com.hsenid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Vidushka on 31/03/17.
 */

@Controller
@RequestMapping("/loginController")
public class Services {
    boolean validUser;
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction trn = session.beginTransaction();

    public boolean checkUser(String user, String password) {
        String hql = "from User where userName=" + user + "and password=" + password;
        Query query = session.createQuery(hql);
        List<User> list = query.list();
        if (list.isEmpty()) {
            validUser = false;
        } else {
            validUser = true;
        }
        return validUser;
    }
}
