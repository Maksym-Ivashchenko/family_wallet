package com.example.familywallet.authentification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
