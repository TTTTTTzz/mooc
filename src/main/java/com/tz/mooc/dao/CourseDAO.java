package com.tz.mooc.dao;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import com.tz.mooc.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CourseDAO extends JpaRepository<Course,Integer> {
    Page<Course> findBySubject(Subject subject, Pageable pageable);
    //todo 什么原理
    Page<Course> findAllByUser(User user,Pageable pageable);

    List<Course> findAllBySubject(Subject subject);

    List<Course> findAllByUser(User user);
}
