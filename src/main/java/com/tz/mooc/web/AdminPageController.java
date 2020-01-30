package com.tz.mooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
    @GetMapping(value="/admin")
    public String admin(){
        return "redirect:admin_subject_list";
    }

    @GetMapping(value="/admin_subject_list")
    public String listSubject(){
        return "admin/listSubject";
    }

    @GetMapping(value="/admin_subject_edit")
    public String editSubject(){ return "admin/editSubject"; }
}
