package com.tz.mooc.service;

import com.tz.mooc.dao.SubjectDAO;

import java.util.List;

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
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(start, size,sort);

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =subjectDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<Subject> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return subjectDAO.findAll(sort);
    }
}
