package com.tz.mooc.config;

import com.tz.mooc.pojo.Course;

public class CourseProgress {
    private Course course;
    private double progress;

    public CourseProgress(Course course, double progress){
        this.course=course;
        this.progress=progress;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
