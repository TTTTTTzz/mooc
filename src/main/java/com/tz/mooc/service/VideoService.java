package com.tz.mooc.service;


import com.tz.mooc.dao.VideoDAO;
import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Video;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Optional<Video> getByCourse(int cid){return  videoDAO.findByCourse(courseService.get(cid).get());}

    public void update(Video bean){
        videoDAO.save(bean);
    }

    public Page4Navigator<Video> listByTeacher(int tid, int start, int size, int navigatePages) {
        //Course course = courseService.get(cid).get();
        List<Course> courseByTeacher = courseService.listByTeacher(tid);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size,sort);
        List<Video> videos = new ArrayList<>();//videoDAO.findVideosByCourse(courseByTeacher);
        for (Course course: courseByTeacher) {
            List<Video> list = videoDAO.findVideosByCourse(course);
            videos.addAll(list);
            //videos.add(list);
        }


        Page<Video> pageFromJPA = new PageImpl<Video>(videos, pageable, videos.size());

        //Page<Video> pageFromJPA =videoDAO.findVideosByCourse(courseByTeacher);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
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

    public List<Video> getListByCourse(int cid){
        return videoDAO.findAllByCourse(courseService.get(cid).get());
    }
}
