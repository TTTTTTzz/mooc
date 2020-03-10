package com.tz.mooc.dao;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectDAO extends JpaRepository<Subject, Integer> {

}
