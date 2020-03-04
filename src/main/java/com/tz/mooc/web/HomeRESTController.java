package com.tz.mooc.web;

import com.tz.mooc.config.JwtToken;
import com.tz.mooc.pojo.User;
import com.tz.mooc.service.UserService;
import com.tz.mooc.util.JWTUtil;
import com.tz.mooc.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class HomeRESTController { //后台管理的登陆
    @Autowired
    UserService userService;

    @PostMapping("/homelogin")
    public Object login(@RequestBody User bean, HttpSession session) {
        String email = bean.getEmail();
        email = HtmlUtils.htmlEscape(email);
        Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken token = new UsernamePasswordToken(email, bean.getPassword());
        AuthenticationToken token = new JwtToken(JWTUtil.encode(String.valueOf(bean.getId())));
        try {
            subject.login(token);
            User user = userService.getByEmail(email);
            session.setAttribute("user", user);
            int role_code = user.getRid();
            return Result.success(role_code);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return Result.fail(message);
        }

        /*Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new JwtToken(JWTUtil.encode(String.valueOf(bean.getId())));
        subject.login(token);
        Session session = subject.getSession();
        session.setAttribute("subject", subject);
        return "admin/adminHome";*/
        /*UsernamePasswordToken token = new UsernamePasswordToken(bean.getName(), bean.getPassword());
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "admin/adminHome";

        } catch (AuthenticationException e) {
            System.out.println("验证失败");
            return "login";
        }*/
        //return JWTUtil.encode("123");

    }
}