package com.hsenid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vidushka on 31/03/17.
 */

@Controller
@RequestMapping("/loginController")
public class Services {
    boolean validUser;

    public boolean validateUser(String user, String password) {
        if (user.equals("123") && password.equals("123")) {
            validUser = true;
        } else {
            validUser = false;
        }
        return validUser;
    }
}
