package com.tz.mooc.web;

import com.tz.mooc.pojo.Subject;
import com.tz.mooc.service.CourseService;
import com.tz.mooc.service.SubjectService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @Autowired
    CourseService courseService;
    @GetMapping("/subjects")
    public Page4Navigator<Subject> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Subject> page =subjectService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/subjects/all")
    public Map<Integer,String> getAllSubjects(){
        return subjectService.list();
    }

    @PostMapping("/subjects")
    public Object add(@RequestBody Subject bean, HttpServletRequest request) throws Exception{
        subjectService.add(bean);
        return bean;
    }

    @DeleteMapping("/subjects/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        if(courseService.getBySubject(id).size()!=0){
            return "-1";
        }else {
            subjectService.delete(id);
            return null;
        }
    }

    @GetMapping("/subjects/{id}")
    public Optional<Subject> get(@PathVariable("id") int id) throws Exception {
        return subjectService.get(id);
    }

    @PutMapping("/subjects/{id}")
    public Object update(@RequestBody Subject bean, HttpServletRequest request) throws Exception {
        subjectService.update(bean);
        return bean;
    }

}
