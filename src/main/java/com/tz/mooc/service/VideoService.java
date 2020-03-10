package com.tz.mooc.service;


import com.tz.mooc.dao.CourseDAO;
import com.tz.mooc.dao.VideoDAO;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Subject;
import com.tz.mooc.pojo.Video;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService  {
    @Autowired VideoDAO videoDAO;
    @Autowired CourseService courseService;

    public void add(Video bean){
        videoDAO.save(bean);
    }

    public void delete(int id){
        videoDAO.deleteById(id);
    }

    public Optional<Video> get(int id){
        return videoDAO.findById(id);
    }

    public Optional<Video> getByCourse(int cid){return  videoDAO.findAllByCourse(courseService.get(cid).get());}

    public void update(Video bean){
        videoDAO.save(bean);
    }

    public Page4Navigator<Video> list(int cid, int start, int size, int navigatePages) {
        Course course = courseService.get(cid).get();

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);

        Page<Video> pageFromJPA =videoDAO.findByCourse(course,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public Page4Navigator<Video> list(int start, int size, int navigatePages) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);

        Page<Video> pageFromJPA =videoDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
}
