package com.tz.mooc.service;

import com.tz.mooc.dao.SubjectDAO;

import java.util.*;

import com.tz.mooc.pojo.Subject;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired SubjectDAO subjectDAO;

    public Page4Navigator<Subject> list(int start, int size,int navigatePages){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);

        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =subjectDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public Map<Integer,String> list(){
        List<Subject> subjects = subjectDAO.findAll();
        Map<Integer,String> namelist = new HashMap<>();
        for (Subject one: subjects) {
            namelist.put(one.getId(),one.getName());
        }
        return namelist;
    }

    public void add(Subject bean) {
        subjectDAO.save(bean);
    }

    public void delete(int id) {
        subjectDAO.deleteById(id);
    }

    public Optional<Subject> get(int id) {
        return subjectDAO.findById(id);
    }

    public void update(Subject bean) {
        subjectDAO.save(bean);
    }
}
