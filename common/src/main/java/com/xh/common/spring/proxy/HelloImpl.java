package com.xh.common.spring.proxy;

/**
 * @author xt
 * @date 2020/8/25
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello!" + name);
    }
}
