package com.tz.mooc.web;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.service.CourseService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired CourseService courseService;

    @GetMapping("/subjects/{sid}/courses")
    public Page4Navigator<Course> list(@PathVariable("sid") int sid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Course> page =courseService.list(sid, start, size,5);
        return page;
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> get(@PathVariable("id") int id) throws Exception {
        Optional<Course> bean=courseService.get(id);
        return bean;
    }

    @PostMapping("/courses")
    public Object add(@RequestBody Course bean) throws Exception {
        courseService.add(bean);
        return bean;
    }

    @DeleteMapping("/courses/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        courseService.delete(id);
        return null;
    }

    @PutMapping("/courses")
    public Object update(@RequestBody Course bean) throws Exception {
        courseService.update(bean);
        return bean;
    }
}
