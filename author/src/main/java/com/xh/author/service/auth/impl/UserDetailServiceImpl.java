package com.xh.author.service.auth.impl;

import com.xh.author.mapper.user.UserMapper;
import com.xh.author.pojo.XhUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author xt
 * @date 2020/9/20
 * 登录认证
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserMapper xhUserMapper;

    @Autowired
    public  UserDetailServiceImpl(UserMapper xhUserMapper){
        this.xhUserMapper = xhUserMapper;
    }



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        XhUser user = xhUserMapper.getByName(name);

        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在!");
        }

        return null;
    }
}
