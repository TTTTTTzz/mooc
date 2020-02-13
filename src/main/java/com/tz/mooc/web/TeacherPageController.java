package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherPageController {
    @GetMapping(value="/teacher")
    public String admin(){
        return "teacher/teacherHome";
    }
}
