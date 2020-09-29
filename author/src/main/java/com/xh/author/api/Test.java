package com.xh.author.api;

import com.xh.author.pojo.XhUser;
import com.xh.author.service.user.XhUserService;
import com.xh.common.list.ArrayList;
import javafx.collections.transformation.SortedList;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<XhUser> list = new ArrayList();
        XhUser user = new XhUser();
        user.setAge(10);
        list.add(user);
        XhUser user4 = new XhUser();
        user4.setAge(13);
        list.add(user4);
        XhUser user2 = new XhUser();
        user2.setAge(11);
        list.add(user2);
        XhUser user3 = new XhUser();
        user3.setAge(12);
        list.add(user3);
    }
}

