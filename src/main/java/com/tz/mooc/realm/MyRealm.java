package com.tz.mooc.realm;

import com.tz.mooc.config.JwtToken;
import com.tz.mooc.pojo.Role;
import com.tz.mooc.pojo.User;
import com.tz.mooc.service.RoleService;
import com.tz.mooc.service.UserService;
import com.tz.mooc.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @Override
    public String getName() {
        return "myRealm";
    }



    /**
     *  默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*String token = (String) auth.getCredentials();
        String id = JWTUtil.decode(token);  // 解密Token
        if (id == null) {
            // Token解密失败，抛出异常
            throw new AuthenticationException("Invalid token.");
        }
        String password = JWTUtil.decodePassword(token);
        String passwordInDB = userService.get(Integer.parseInt(id)).get().getPassword();
        if (!password.equals(passwordInDB)){
            throw new AuthenticationException("Invalid token.");
        }
        // Token解密成功，返回SimpleAuthenticationInfo对象
        return new SimpleAuthenticationInfo(token, token, "myRealm"); //todo  salt?
    */

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken; //获得用户输入的用户名,这个对象就是login()传递过来的，将它强转以取出封装的用户名
        String userEmail = token.getUsername();

        User user=userService.getByEmail(userEmail);
        if(user == null) //用户不存在，返回null
        {
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 从principals中拿到Token令牌
        Subject subject = SecurityUtils.getSubject(); //获得一个Subject对象
        User user = (User) subject.getPrincipal(); //获得登录的对象

        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            // 获取当前用户的所有角色，并且通过addRole添加到simpleAuthorizationInfo当中
            // 这样当Shiro内部检查用户是否有某项权限时就会从SimpleAuthorizationInfo中拿取校验
            Role role = roleService.getById(user.getRid());
           // Role role = userService.getRoleById(userId);
            simpleAuthorizationInfo.addRole(role.getName());
            return simpleAuthorizationInfo;
        }
        return null;
    }
}