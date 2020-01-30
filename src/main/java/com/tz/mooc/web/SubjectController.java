package com.tz.mooc.web;

import com.tz.mooc.pojo.Subject;
import com.tz.mooc.service.SubjectService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @GetMapping("/subjects")
    public Page4Navigator<Subject> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Subject> page =subjectService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @PostMapping("/subjects")
    public Object add(Subject bean, HttpServletRequest request) throws Exception{
        subjectService.add(bean);
        return bean;
    }

    @DeleteMapping("/subjects/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        subjectService.delete(id);
        return null;
    }

}
