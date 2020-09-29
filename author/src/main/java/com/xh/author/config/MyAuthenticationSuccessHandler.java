package com.xh.author.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/9/22- 22:41
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private String url;

    public MyAuthenticationSuccessHandler(String url){
        this.url = url;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(url);
    }
}
