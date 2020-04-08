package com.tz.mooc.web;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import com.tz.mooc.config.JwtToken;
import com.tz.mooc.pojo.User;
import com.tz.mooc.service.UserService;
import com.tz.mooc.util.JWTUtil;
import com.tz.mooc.util.Result;
import com.tz.mooc.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        AuthenticationToken token = new JwtToken(JWTUtil.encode(String.valueOf(bean.getId()),bean.getPassword()));
        try {
            subject.login(token);
            //成功登陆 //todo test 不存在的账号
            User user = userService.getByEmail(email);
            User temp = new User();
            temp.setEmail(user.getEmail());
            temp.setName(user.getName());
            temp.setRid(user.getRid());
            temp.setId(user.getId());
            session.setAttribute("token", token); //todo
            return Result.success(temp);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return Result.fail(message);
        }
    }

    @PostMapping("/mooclogin")
    public Object moocLogin(@RequestBody User bean, HttpSession session) {
        if (userService.getSaltByEmail(bean.getEmail()) == null) {
            String message = "账号不存在，请注册";
            return Result.fail(message);
        }
        Subject subject = SecurityUtils.getSubject();
        bean.setPassword(UserUtil.getInputPasswordCiph(bean.getPassword(), userService.getSaltByEmail(bean.getEmail())));
        try {
            UserUtil.userLogin(bean);
            subject.checkRole("student");
            session.setAttribute("userName",bean.getName());
            User user = new User();
            user.setName(userService.getByEmail(bean.getEmail()).getName());
            user.setEmail(bean.getEmail());
            return Result.success(user);
        } catch (AuthenticationException e) {
            String message = "账号或密码错误，请重新输入";
            return Result.fail(message);
        } catch (AuthorizationException e) {
            String message = "用户不存在，请注册";
            return Result.fail(message);
        }
    }

    @PostMapping("/moocRegister")
    public Object moocRegister(@RequestBody User user, HttpSession session){
        String password = user.getPassword();

        String[] saltAndCiphertext = UserUtil.encryptPassword(password);

        user.setSalt(saltAndCiphertext[0]);
        user.setPassword(saltAndCiphertext[1]);
        user.setRid(3);

        userService.userRegister(user);

        return moocLogin(user, session); //使用户沆注册后立马登录
    }

    @GetMapping("/moocLogout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
    }
}