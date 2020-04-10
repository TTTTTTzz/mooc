package com.tz.mooc.service;

import com.tz.mooc.config.CourseProgress;
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

    public List<CourseProgress> getCourseListByStudent(int uid){
        List<UserCourse> ucList = userCourseDAO.findAllByUid(uid);
        List<CourseProgress> courseList = new ArrayList<>();
        for (UserCourse ucbean:ucList) {
            CourseProgress c = new CourseProgress(courseService.get(ucbean.getCid()).get(),ucbean.getProgress());
            courseList.add(c);
        }
        return courseList;
    }

    public void add(UserCourse bean){
        userCourseDAO.save(bean);
    }

    public void delete(int id){
        userCourseDAO.deleteById(id);
    }

    public void update(UserCourse bean){
        userCourseDAO.save(bean);
    }

    public UserCourse getByUserAndCourse(int uid,int cid){
        return userCourseDAO.findAllByUidAndCid(uid,cid);
    }

}
