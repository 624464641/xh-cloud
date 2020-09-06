package com.xh.common.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.InvocationHandler;

/**
 * @author xt
 * @date 2020/8/24
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 获取到bean的定义信息
        BeanDefinition beanDefinition =  configurableListableBeanFactory.getBeanDefinition("a");

    }
}
