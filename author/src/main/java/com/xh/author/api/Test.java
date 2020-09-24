package com.xh.author.api;

import com.xh.author.service.user.XhUserService;
import com.xh.common.list.ArrayList;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @author xt
 * @date 2020/8/11
 */
@RestController("/auth")
public class Test {

    @Autowired
    private XhUserService xhUserService;


    @GetMapping("/say")
    public void say() {
        xhUserService.loadUserByUsername("小华");
    }


    @GetMapping("/login")
    // 指定角色
    @Secured("ROLE_abc")
    public String login() {
        System.out.println("登录进来了!");
        return " login sucess";
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList();
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()) {

        }

        // Integer [] sources = new Integer[100] ;
        // Integer [] targer = new Integer[100] ;
        // for (int i = 0; i < 100; i++) {
        //     sources[i]  = i;
        // }
        // for (int i = 0; i < 50; i++) {
        //     targer[i]  = 2*i;
        // }
        // int count = 0;
        // for (int i = 0; i <sources.length ; i++) {
        //     boolean flag = false;
        //     for (int j = 0; j <targer.length ; j++) {
        //         count++;
        //         if(sources[i].equals(targer[j])){
        //             flag = true;
        //         }
        //     }
        //     if(!flag){
        //         System.out.println(sources[i]);
        //         System.out.println("------"+count);
        //     }
        // }
    }
}
