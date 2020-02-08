package com.tz.mooc.dao;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course,Integer> {
    Page<Course> findBySubject(Subject subject, Pageable pageable);
}
