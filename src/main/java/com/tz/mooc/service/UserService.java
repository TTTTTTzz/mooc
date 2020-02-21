package com.tz.mooc.service;

import com.tz.mooc.dao.UserDAO;
import com.tz.mooc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired UserDAO userDAO;

    //todo register

    public Optional<User> get(int id){
        return userDAO.findById(id);
    }
}
