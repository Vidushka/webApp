package com.hsenid; /**
 * Created by Vidushka on 29/03/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
    String userName;
    String password;
    String responsePage;

    /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Services userService = (Services) context.getBean("userServices");*/
    Services userService = new Services();

    @RequestMapping(method = RequestMethod.POST)
    public String validateUser(Model model, @ModelAttribute("User") User user) {
        userName = user.getUserName();
        password = user.getPassword();

        if (userService.validateUser(userName, password)) {
            responsePage = "success";
        } else {
            responsePage = "fail";
        }
        return responsePage;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void val() {

    }
}