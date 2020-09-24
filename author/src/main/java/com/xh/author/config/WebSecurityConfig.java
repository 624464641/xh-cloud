package com.xh.author.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author xt
 * @date 2020/9/20
 * <p>
 * WebSecurityConfigurerAdapter
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // @Autowired
    // private UserDetailServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;


    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     // 设置
    //     auth.userDetailsService(userDetailsService);
    // }

    /**
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登录页面
        http.formLogin()
                .loginPage("/")
                // 和表单提交地址对应
                .loginProcessingUrl("/login")
                // 登录成功后返回页面 并且只接受post请求
                .successForwardUrl("/home")
                .failureForwardUrl("/error");

        // 授权
        http.authorizeRequests()
                // 不需要认证
                .antMatchers("/login").permitAll()
                // 对静态资源放行
                .antMatchers("/**/*.jpg")
                // 有哪些权限访问资源
                .hasAnyAuthority("")
                // 基于IP地址

                // 所有的请求都必须认证 必须放在最后位置
                .anyRequest().authenticated();


        // 记住密码
        http.rememberMe()
                .tokenRepository(persistentTokenRepository);


        // 防火墙
        http.csrf().disable();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
