package com.tz.mooc.service;

import com.tz.mooc.dao.CourseDAO;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import com.tz.mooc.pojo.User;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired CourseDAO courseDAO;
    @Autowired SubjectService subjectService;
    @Autowired UserService userService;

    public void add(Course bean){
        courseDAO.save(bean);
    }

    public void delete(int id){
        courseDAO.deleteById(id);
    }

    public Optional<Course> get(int id){
        return courseDAO.findById(id);
    }

    public void update(Course bean){
        courseDAO.save(bean);
    }

    public Page4Navigator<Course> list(int sid, int start, int size, int navigatePages) {
        Subject subject = subjectService.get(sid).get();

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);

        //todo safe：暴露密码？？？？？
        Page<Course> pageFromJPA =courseDAO.findBySubject(subject,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);

    }

    //todo
    public Page4Navigator<Course> listByTeacher(int tid, int start, int size, int navigatePages){
        User teacher = userService.get(tid).get();

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);

        Page<Course> pageFromJPA =courseDAO.findByUser(teacher,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

}