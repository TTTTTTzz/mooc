package com.tz.mooc.service;

import com.tz.mooc.dao.UserDAO;
import com.tz.mooc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired UserDAO userDAO;

    //todo register
    public Optional<User> get(int id){
        return userDAO.findById(id);
    }

    public User getByName(String name){ return userDAO.findByName(name); }

    public Map<Integer,String> getByRole(int rid){
        ArrayList<User> teacher = userDAO.findAllByRid(rid);
        Map<Integer,String> namelist = new HashMap<>();
            for (User one:teacher) {
            namelist.put(one.getId(),one.getName());
        }
        return namelist;
    }
}
