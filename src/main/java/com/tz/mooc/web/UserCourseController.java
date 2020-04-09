package com.tz.mooc.web;

import com.tz.mooc.config.CourseProgress;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.service.UserCourseService;
import com.tz.mooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCourseController {
    @Autowired UserCourseService userCourseService;
    @Autowired
    UserService userService;

    @GetMapping("uc/{email}/all")
    List<CourseProgress> list(@PathVariable("email") String email) throws Exception {
        return userCourseService.getCourseListByStudent(userService.getByEmail(email).getId());
    }

}
