package com.tz.mooc.web;

import com.tz.mooc.pojo.Video;
import com.tz.mooc.service.VideoService;
import com.tz.mooc.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/courses/{cid}/videos")
    public Page4Navigator<Video> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Video> page =videoService.list(cid, start, size,5);
        return page;
    }


}
