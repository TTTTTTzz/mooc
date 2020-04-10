package com.tz.mooc.web;

import com.tz.mooc.pojo.Course;
import com.tz.mooc.pojo.User;
import com.tz.mooc.service.UserService;
import com.tz.mooc.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/users/{id}")
    public Object updateInfo(@PathVariable("id") int id,@RequestBody User bean) throws Exception {
        User user=userService.get(id).get();
        user.setEmail(bean.getEmail());
        user.setName(bean.getName());
        userService.updateUserInfo(user);
        return bean;
    }

    @PutMapping("/users/password/{id}")
    public Object updatePassword(@PathVariable("id") int id,@RequestBody User bean) throws Exception {
        String newPassword = bean.getPassword();
        String[] newTemp = UserUtil.encryptPassword(newPassword);
        bean.setPassword(newTemp[0]);
        bean.setSalt(newTemp[1]);
        userService.updateUserInfo(bean);
        return bean;
    }
}
