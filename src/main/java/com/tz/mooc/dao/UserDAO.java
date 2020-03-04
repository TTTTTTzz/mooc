package com.tz.mooc.dao;

import com.tz.mooc.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Integer> {
    ArrayList<User> findAllByRid(int rid);

    int findRidById(int id);
    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

}
