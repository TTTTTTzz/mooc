package com.tz.mooc.service;

import com.tz.mooc.dao.UserCourseDAO;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.User;
import com.tz.mooc.pojo.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseService {
    @Autowired
    UserCourseDAO userCourseDAO;
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;

    public List<Course> getCourseListByStudent(int uid){
        List<UserCourse> ucList = userCourseDAO.findAllByUid(uid);
        List<Course> courseList = new ArrayList<>();
        for (UserCourse ucbean:ucList) {
            Course c = courseService.get(ucbean.getCid()).get();
            courseList.add(courseService.get(ucbean.getCid()).get());
        }
        return courseList;
    }

}
