package com.xh.common.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xt
 * @date 2020/8/25
 */
public class InterfaceProxy implements InvocationHandler {

    // 目标对象
    private Object target;

    public InterfaceProxy(){
    }

    public InterfaceProxy(Object target){
        this.target =target;
    }


    // 获取代理对象
    public <T> T getProxy(){

        /**
         *ClassLoader loader,  类加载器
         * Class<?>[] interfaces, 接口
         * InvocationHandler h 反射
         */
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces() , this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object object = method.invoke(target , args);
        this.after();
        return object;
    }

    public void before(){
        System.out.println("before init ...");
    }

    public void after(){
        System.out.println("after init ...");
    }

}
