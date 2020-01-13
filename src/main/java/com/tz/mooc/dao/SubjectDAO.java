package com.tz.mooc.dao;

import org.apache.shiro.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDAO extends JpaRepository<Subject, Integer> {

}
