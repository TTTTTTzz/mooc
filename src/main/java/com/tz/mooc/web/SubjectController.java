package com.tz.mooc.web;

import com.tz.mooc.pojo.Subject;
import com.tz.mooc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @GetMapping("/subjects")
    public List<Subject> list() throws Exception{
        return subjectService.list();
    }
}
