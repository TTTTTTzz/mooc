package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    @RequestMapping("/home")
    public String test(Model m) throws Exception{
        return "home";
    }

}