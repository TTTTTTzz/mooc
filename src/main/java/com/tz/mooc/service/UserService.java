package com.tz.mooc.service;

import com.tz.mooc.dao.UserDAO;
import com.tz.mooc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired UserDAO userDAO;
//    public List<User> list(){
//    }

    public String createUser(String name, String user){return null;}

    public User getByName(String name){
        return  userDAO.findByName(name);
    }


}
