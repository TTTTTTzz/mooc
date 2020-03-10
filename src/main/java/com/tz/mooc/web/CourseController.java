package com.tz.mooc.web;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.service.CourseService;
import com.tz.mooc.service.VideoService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired CourseService courseService;
    @Autowired VideoService videoService;

    @GetMapping("/subjects/{sid}/courses")
    public Page4Navigator<Course> list(@PathVariable("sid") int sid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Course> page =courseService.list(sid, start, size,5);
        return page;
    }

    @GetMapping("courses/all")
    public Page4Navigator<Course> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        Page4Navigator<Course> page =courseService.list(start, size,5);
        return page;
    }

    @GetMapping("/courses/all/{tid}")
    public Page4Navigator<Course> listByTid(@PathVariable("tid") int tid,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        Page4Navigator<Course> page =courseService.listByTeacher(tid,start, size,5);
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
        if(videoService.getByCourse(id).isPresent()){
            return "-1";
        }else {
            courseService.delete(id);
            return null;
        }
    }

    @PutMapping("/courses/{id}")
    public Object update(@PathVariable("id") int id,@RequestBody Course bean) throws Exception {
        courseService.update(bean);
        return bean;
    }
}
