package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
    @GetMapping(value="/admin")
    public String admin(){
        return "admin/adminHome";
    }

    @GetMapping(value="/admin_subject_list")
    public String listSubject(){
        return "admin/listSubject";
    }

    @GetMapping(value="/admin_subject_edit")
    public String editSubject(){ return "admin/editSubject"; }

    @GetMapping(value = "/admin_course_all")
    public String allCourse(){
        return "admin/listCourse";
    }

    @GetMapping(value="/admin_course_list")
    public String listCourse(){ return "admin/oneCourse"; }

    @GetMapping(value="/admin_course_edit")
    public String editCourse(){ return "admin/editCourse"; }

    @GetMapping(value = "/admin_video_all")
    public String allVideo(){
        return "admin/listVideo";
    }

    @GetMapping(value="/admin_video_list")
    public String listVideo(){ return "admin/oneVideo"; }
}
