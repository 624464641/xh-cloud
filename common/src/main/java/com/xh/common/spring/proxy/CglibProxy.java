package com.xh.common.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.nio.channels.FileChannel;

/**
 * @author xt
 * @date 2020/8/25
 */
public class CglibProxy implements MethodInterceptor {

    // 获取代理对象
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.before();
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        this.after();
        return invokeSuper;
    }

    public void before(){
        System.out.println("cglib before init ...");
    }

    public void after(){
        System.out.println("cglib after init ...");
    }
}
