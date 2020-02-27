package com.tz.mooc.web;

import com.tz.mooc.pojo.User;
import com.tz.mooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public Optional<User> get(@PathVariable("id") int id) throws Exception {
        return userService.get(id);
    }

    @GetMapping("/users/teachers/{rid}")
    public Map<Integer,String> getByRole(@PathVariable("rid") int rid) throws Exception {
        //ArrayList<User> test = userService.getByRole(rid);
        return userService.getByRole(rid);
    }
}
