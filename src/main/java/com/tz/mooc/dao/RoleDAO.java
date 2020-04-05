package com.tz.mooc.dao;

import com.tz.mooc.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleDAO extends JpaRepository<Role,Integer> {
    Optional<Role> findById(int id);
}
