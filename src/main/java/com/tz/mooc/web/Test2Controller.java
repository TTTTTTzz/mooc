package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller {
    @RequestMapping("/test2")
    public String test(Model m) throws Exception{
        return "student/oneCourse";
        //return "test2";
    }
}
