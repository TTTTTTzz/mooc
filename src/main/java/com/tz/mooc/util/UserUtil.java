package com.tz.mooc.util;

import com.tz.mooc.config.JwtToken;
import com.tz.mooc.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.util.HtmlUtils;

public class UserUtil {
    /**
     * 用户注册时加密用户的密码
     * 输入密码明文 返回密文与盐值
     * @param password
     * @return 第一个是密文  第二个是盐值
     */
    public static String[] encryptPassword(String password)
    {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); //生成盐值
        String ciphertext = new Md5Hash(password,salt,3).toString(); //生成的密文

        String[] strings = new String[]{salt, ciphertext};

        return strings;
    }

    /**
     * 获得本次输入的密码的密文
     * @param password
     * @param salt
     * @return
     */
    public static String getInputPasswordCiph(String password, String salt)
    {
        if(salt == null)
        {
            password = "";
        }

        String ciphertext = new Md5Hash(password,salt,3).toString(); //生成的密文

        return ciphertext;
    }

    public static void userLogin(User user){
        Subject subject = SecurityUtils.getSubject(); //获得Subject对象
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword()); //将用户输入的用户名写密码封装到一个UsernamePasswordToken对象中
        subject.login(token);
    }
}
