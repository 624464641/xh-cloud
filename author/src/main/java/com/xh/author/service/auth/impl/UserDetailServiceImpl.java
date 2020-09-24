package com.xh.author.service.auth.impl;

import com.xh.author.service.user.XhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author xt
 * @date 2020/9/20
 * 登录认证
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final XhUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public  UserDetailServiceImpl(XhUserService userService){
        this.userService = userService;

    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        /**
         * 1.根据用户名查找 对象
         * 2.获取用户密码 对比
         *
         */

        if(!"admin".equals(name)){
            throw new UsernameNotFoundException("用户不存在!");
        }

        String password = passwordEncoder.encode("123456");
        return  new User(name , password ,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,norna"));


        // XhUser user = userService.loadUserByUsername(name);
        // if(Objects.isNull(user)){
        //     throw new UsernameNotFoundException("用户不存在!");
        // }
        // // 如果用户存在  则获取资源
        // List<GrantedAuthority> authorityList = new ArrayList<>();
        // // 通过用户id 获取权限列表
        // List<Permission> permissions = null;
        // // 封装 GrantedAuthority 授权信息   role
        // GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissions.get(0).getName());
        // authorityList.add(grantedAuthority);
        // return new User(user.getName() , user.getPassWord() ,  authorityList);
    }
}
