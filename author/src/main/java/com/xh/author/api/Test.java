package com.xh.author.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2020/8/11
 */
@RestController
public class Test {
    @CrossOrigin
    @GetMapping("/say")
    public void say(){
        System.out.println("进来了!");
    }
}