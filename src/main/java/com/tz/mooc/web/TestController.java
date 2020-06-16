package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Model m) throws Exception{
        return "student/oneCourse";
        //return "student/userHome";
        //return "test1";
    }
}
