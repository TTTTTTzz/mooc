package com.tz.mooc.service;

import com.tz.mooc.dao.SubjectDAO;

import java.util.List;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired SubjectDAO subjectDAO;

    public List<Subject> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return subjectDAO.findAll(sort);
    }
}
