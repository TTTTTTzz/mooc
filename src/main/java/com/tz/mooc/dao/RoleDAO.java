package com.tz.mooc.dao;

import com.tz.mooc.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface RoleDAO extends JpaRepository<Role,Integer> {
    //ArrayList<Role> findAllByName(String name);
    //String findNameById(int id);
}
