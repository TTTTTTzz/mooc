package com.tz.mooc.dao;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import com.tz.mooc.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseDAO extends JpaRepository<Course,Integer> {
    Page<Course> findBySubject(Subject subject, Pageable pageable);
    //todo 什么原理
    Page<Course> findByUser(User user,Pageable pageable);

    Optional<Course> findAllBySubject(Subject subject);
}
