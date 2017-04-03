package com.hsenid; /**
 * Created by Vidushka on 29/03/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    String userName;
    String password;
    String responsePage;
    HttpSession session;

    /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Services userService = (Services) context.getBean("userServices");*/
    Services userService = new Services();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateUser(Model model, @ModelAttribute("User") User user, HttpServletRequest request) {
        userName = user.getUserName();
        password = user.getPassword();

        if (request.getSession(false) != null) {
            if (userService.validateUser(userName, password)) {
                responsePage = "success";
                session = request.getSession();
                session.setAttribute("User", userName);
                model.addAttribute("userName", userName);
            } else {
                responsePage = "fail";
                //model.addAttribute("fail", "Fail to login.");
            }
        } else {
            responsePage = "login";
            //model.addAttribute("Warning", "Please login to continue.");
        }
        return responsePage;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void val() {

    }

    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest req){
        if (req.getSession() != null){
            req.getSession().removeAttribute("userName");
            req.getSession().invalidate();
            model.addAttribute("logged_name", "Successfully logged out.");

        }
        return "login";
    }
}