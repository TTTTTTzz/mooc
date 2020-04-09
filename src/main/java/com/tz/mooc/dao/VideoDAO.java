package com.tz.mooc.dao;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoDAO extends JpaRepository<Video, Integer> {
    Page<Video> findByCourse(Course course, Pageable pageable);
    Optional<Video> findAllByCourse(Course course);
    //Page<Video> findVideosByCourse(Optional<Course> courseList, Pageable pageable);
    //todo 或者自定义sql
    List<Video> findVideosByCourse(Course course);
}
