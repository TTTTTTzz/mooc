package com.tz.mooc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user_course")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }


    @Basic
    @Column(name = "uid")
    private int uid;
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "cid")
    private int cid;
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "progress")
    private double progress;

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getProgress() {
        return progress;
    }
}
