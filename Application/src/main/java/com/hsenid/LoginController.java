package com.hsenid; /**
 * Created by Vidushka on 29/03/17.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Services userService = (Services) context.getBean("userServices");*/
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    String userName;
    String password;
    String responsePage;
    HttpSession session;
    Services userService = new Services();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateUser(Model model, @ModelAttribute("User") User user, HttpServletRequest request) {
        userName = user.getUserName();
        password = user.getPassword();

        if (request.getSession().getAttribute("User") == null) {
            if (userService.validateUser(userName, password)) {
                responsePage = "success";
                session = request.getSession();
                session.setAttribute("User", "ABC");
                model.addAttribute("userName", userName);
                logger.info(userName + " is logged in successfully.");
            } else {
                responsePage = "fail";
                //model.addAttribute("fail", "Fail to login.");
                logger.info("Fail to login, incorrect user name or password.");
            }
        } else if (request.getSession().getAttribute("User") != null) {
            responsePage = "success";
            model.addAttribute("loginStatus", "Already logged in.");
            logger.info(userName + " is already logged in.");
        } else {
            responsePage = "login";
            model.addAttribute("Warning", "Please login to continue.");
            logger.info("Redirected to login page.");
        }
        return responsePage;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void val() {

    }

    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest req, HttpServletResponse res) {
        if (req.getSession() != null){
            req.getSession().removeAttribute("User");
            req.getSession().invalidate();
            model.addAttribute("logged_name", "Successfully logged out.");
            if (req.getSession() != null) {
                model.addAttribute("a", "not logout");
            } else {
                model.addAttribute("b", "loged out");
            }

            logger.info("Loged out and session was killed.");

        }

        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }*/
        if (req.getSession() != null) {
            model.addAttribute("a", "not logout");
        } else {
            model.addAttribute("b", "logged out");
        }
        return "redirect:/login";
    }
}