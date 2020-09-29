 package com.xh.author.config;

 import com.xh.author.service.auth.impl.UserDetailServiceImpl;
 import org.mybatis.spring.annotation.MapperScan;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;

 /**
  * @author xt
  * @date 2020/9/20
  */

 @Configuration
 @EnableWebSecurity
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

      //@Autowired
      //private UserDetailServiceImpl userDetailsService;
      //
      //@Bean
      //public PasswordEncoder passwordEncoder(){
      //    return  new BCryptPasswordEncoder();
      //}
      //
      //@Override
      //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //    // 设置
      //    auth.userDetailsService(userDetailsService);
      //}
      //@Override
      //protected void configure(HttpSecurity http) throws Exception {
      //    //http.formLogin().successForwardUrl()
      //}


 }
