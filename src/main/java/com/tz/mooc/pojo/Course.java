package com.tz.mooc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="sid")

    private Subject subject;

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name="tid")

    //todo 安全性 会暴露密码
    private User teacher;

    public User getUser() {
        return teacher;
    }
    public void setUser(User teacher) {
        this.teacher = teacher;
    }
}
