package com.ivanshyrai.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// redirects users to login view

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String authenticate() {
        return "login";
    }
}
