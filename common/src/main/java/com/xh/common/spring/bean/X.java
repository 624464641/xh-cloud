package com.xh.common.spring.bean;


import org.springframework.stereotype.Component;

/**
 * @author xt
 * @date 2020/8/28
 */
@Component
public class X {

    public X(){
        // x 一旦被实例化 则会打印
        System.out.println("X Constructor");
    }
}
