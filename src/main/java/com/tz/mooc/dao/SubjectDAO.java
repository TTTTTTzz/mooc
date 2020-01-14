package com.tz.mooc.dao;

import com.tz.mooc.pojo.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDAO extends JpaRepository<Subject, Integer> {

}
