package com.xh.author.api;

import com.xh.author.service.user.XhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2020/8/11
 */
@RestController("/auth")
public class Test {

    @Autowired
    private XhUserService xhUserService;


    @GetMapping("/say")
    public void say(){
        xhUserService.loadUserByUsername("小华");
    }

}
