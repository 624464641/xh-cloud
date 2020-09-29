 package com.xh.author.service.auth.impl;

 import com.xh.author.pojo.XhUser;
 import com.xh.author.service.user.XhUserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

 import java.security.Permission;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;

 /**
  * @author xt
  * @date 2020/9/20
  * 登录认证
  */
 @Service
 public class UserDetailServiceImpl implements UserDetailsService {

     private final XhUserService userService;

     @Autowired
     public  UserDetailServiceImpl(XhUserService userService){
         this.userService = userService;
     }



      @Override
      public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
          XhUser user = userService.loadUserByUsername(name);

          if(Objects.isNull(user)){
              throw new RuntimeException("用户不存在!");
          }
          // 如果用户存在  则获取资源
          List<GrantedAuthority> authorityList = new ArrayList<>();
          // 通过用户id 获取权限列表
          List<Permission> permissions = null;
          // 封装 GrantedAuthority 授权信息   role
          GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissions.get(0).getName());
          authorityList.add(grantedAuthority);
          return new User(user.getName() , user.getPassWord() ,  authorityList);
      }
 }
