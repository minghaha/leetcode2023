//package com.mybatis.spring;
//
//import com.mybatis.spring.mapper.OrderMapper;
//import com.mybatis.spring.mapper.UserMapper;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * Created on 2023/4/6.
// *
// * @author lichuanming
// */
//@Component
//public class ZhouyuBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(ZhouyuFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        beanDefinitionRegistry.registerBeanDefinition("userMapper", beanDefinition);
//
//        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition2.setBeanClass(ZhouyuFactoryBean.class);
//        beanDefinition2.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//        beanDefinitionRegistry.registerBeanDefinition("orderMapper", beanDefinition2);
//    }
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//
//    }
//}
