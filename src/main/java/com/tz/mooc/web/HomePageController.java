package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

    @GetMapping(value="/mooc")
    public String mooc(){
        return "student/studentHome";
    }

}
