package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentPageController {
    @GetMapping(value="/user_home")
    public String home(){
        return "student/userHome";
    }

    @GetMapping(value = "/user_course")
    public String oneCourse(){return "student/oneCourse";}

    @GetMapping(value = "/user_setting")
    public String setting(){return "student/userProfile";}

}
