package com.tz.mooc.dao;

import com.tz.mooc.pojo.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseDAO extends JpaRepository<UserCourse, Integer> {
    List<UserCourse> findAllByUid(int id);
    UserCourse findAllByUidAndCid(int uid,int cid);
}
