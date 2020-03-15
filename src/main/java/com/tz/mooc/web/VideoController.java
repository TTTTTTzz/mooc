package com.tz.mooc.web;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.Video;
import com.tz.mooc.service.VideoService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @PostMapping("/videos")
    public Object add(Video bean,MultipartFile videoFile, HttpServletRequest request) throws Exception {
        videoService.add(bean);
        bean.setAddress("./video/"+bean.getId()+".mp4");
        videoService.update(bean);
        saveOrUpdateImageFile(bean, videoFile, request);
        return bean;
    }
    public void saveOrUpdateImageFile(Video bean, MultipartFile videoFile, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("video"));
        File file = new File(imageFolder,bean.getId()+".mp4");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        videoFile.transferTo(file);
        //BufferedImage img = ImageUtil.change2jpg(file);
    }

    @GetMapping("videos/{tid}/all")
    public Page4Navigator<Video> listByTeacher(@PathVariable("tid") int tid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Video> page =videoService.listByTeacher(tid, start, size,5);
        return page;
    }

    @GetMapping("/courses/{cid}/videos")
    public Page4Navigator<Video> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Video> page =videoService.list(cid, start, size,5);
        return page;
    }

    @GetMapping("videos/all")
    public Page4Navigator<Video> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Video> page =videoService.list(start, size,5);
        return page;
    }

    @DeleteMapping("/videos/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        videoService.delete(id);
        return null;
    }


}
