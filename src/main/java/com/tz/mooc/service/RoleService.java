package com.tz.mooc.service;

import com.tz.mooc.dao.RoleDAO;
import com.tz.mooc.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    RoleDAO roleDAO;

    public Role getById(int id){
        return roleDAO.findById(id).get();
    }
}
