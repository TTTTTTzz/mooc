package com.tz.mooc.dao;

import com.tz.mooc.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByName(String name);

    ArrayList<User> findAllByRid(int rid);
}
