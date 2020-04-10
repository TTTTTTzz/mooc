package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentPageController {
    @GetMapping(value="/userHome")
    public String admin(){
        return "student/userHome";
    }

    @GetMapping(value = "/user_course")
    public String oneCourse(){return "student/oneCourse";}

}
