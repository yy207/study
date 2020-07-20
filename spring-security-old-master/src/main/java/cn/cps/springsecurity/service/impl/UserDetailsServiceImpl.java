package cn.cps.springsecurity.service.impl;

import cn.cps.springsecurity.entity.SecurityUser;
import cn.cps.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 自定义userDetailsService - 认证用户详情
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    HashMap<String,User> map = new HashMap<String,User>(){
        {
            //密码 123456 → 96e79218965eb72c92a549dd5a330112
            put("Cps",new User(1,"Cps","96e79218965eb72c92a549dd5a330112"));
            put("admin",new User(2,"admin","96e79218965eb72c92a549dd5a330112"));
        }
    };

    /***
     * 根据账号获取用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        User user = map.get(username);

        // 判断用户是否存在
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<String> authorities = Arrays.asList("admin","salve");//permissionService.selectPermissionValueByUserId(user.getId());
        SecurityUser securityUser = new SecurityUser(user);
        securityUser.setPermissionValueList(authorities);
        return securityUser;
    }

}
