package com.xh.common.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xt
 * @date 2020/8/28
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("start");
        AnnotationConfigApplicationContext  tx = new AnnotationConfigApplicationContext();
        tx.register(Appconfig.class);
        tx.refresh();
    }
}
