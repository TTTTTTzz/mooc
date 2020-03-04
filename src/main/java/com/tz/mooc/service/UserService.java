package com.tz.mooc.service;

import com.tz.mooc.dao.UserDAO;
import com.tz.mooc.pojo.Role;
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
    @Autowired RoleService roleService;

    //todo register
    public Optional<User> get(int id){
        return userDAO.findById(id);
    }

    public User getById(int id){ return userDAO.findById(id).get(); }

    public User getByEmail(String email){
        return userDAO.findByEmail(email).get();
    }

    public Map<Integer,String> getByRole(int rid){
        ArrayList<User> teacher = userDAO.findAllByRid(rid);
        Map<Integer,String> namelist = new HashMap<>();
            for (User one:teacher) {
            namelist.put(one.getId(),one.getName());
        }
        return namelist;
    }

    public Role getRoleById(int id){
        return roleService.getById(userDAO.findRidById(id));
    }

}
