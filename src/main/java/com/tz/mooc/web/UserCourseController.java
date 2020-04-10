package com.tz.mooc.web;

import com.tz.mooc.config.CourseProgress;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.UserCourse;
import com.tz.mooc.service.UserCourseService;
import com.tz.mooc.service.UserService;
import com.tz.mooc.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCourseController {
    @Autowired UserCourseService userCourseService;
    @Autowired UserService userService;
    @Autowired VideoService videoService;

    @GetMapping("uc/{email}/all")
    List<CourseProgress> list(@PathVariable("email") String email) throws Exception {
        return userCourseService.getCourseListByStudent(userService.getByEmail(email).getId());
    }

    @PostMapping("uc")
    public Object add(@RequestBody UserCourse bean) throws Exception {
        double size= videoService.getListByCourse(bean.getCid()).size();
        double progress=userCourseService.getByUserAndCourse(bean.getUid(),bean.getCid()).getProgress();
        progress+=1/size;
        bean.setProgress(progress);
        userCourseService.add(bean);
        return bean;
    }



}
