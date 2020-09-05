package com.xh.common.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xt
 * @date 2020/8/25
 */
public class StaticProxy implements Hello {
    private Hello hello;

    public StaticProxy(Hello hello){
        this.hello = hello;
    }

    private void before() {
        System.out.println("static proxy before ...");
    }

    private void after() {
        System.out.println("static proxy after ...");
    }

    @Override
    public void say(String name) {
        this.before();
        hello.say(name);
        this.after();
    }
}
