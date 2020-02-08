package com.tz.mooc.service;

import com.tz.mooc.dao.CourseDAO;
import com.tz.mooc.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    SubjectService subjectService;

    public void add(Course bean){
        courseDAO.save(bean);
    }

    public void delete(int id){
        courseDAO.deleteById(id);
    }

    public Course get(int id){
        return courseDAO.getOne(id);
    }
}