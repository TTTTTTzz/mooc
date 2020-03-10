package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherPageController {
    @GetMapping(value="/teacher")
    public String teacher(){
        return "teacher/teacherHome";
    }

    @GetMapping(value="/teacher_course_list")
    public String listCourse(){
        return "teacher/listCourse";
    }

    @GetMapping(value = "/teacher_video_list")
    public String listVideo(){
        return "teacher/oneVideo";
    }

    @GetMapping(value = "/teacher_video_all")
    public String allVideo(){
        return "teacher/listVideo";
    }
}
