package com.tz.mooc.service;

import com.tz.mooc.dao.SubjectDAO;

import java.util.List;

import com.tz.mooc.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired SubjectDAO subjectDAO;

    public List<Subject> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return subjectDAO.findAll(sort);
    }
}
