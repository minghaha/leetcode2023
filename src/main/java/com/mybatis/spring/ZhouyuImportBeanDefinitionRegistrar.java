package com.mybatis.spring;

import com.mybatis.spring.aop.ZhouyuMapperScan;
import com.mybatis.spring.mapper.OrderMapper;
import com.mybatis.spring.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */
public class ZhouyuImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ZhouyuMapperScan.class.getName());
        String path = (String) annotationAttributes.get("value");
        //System.out.println("path: " + path);

        ZhouyuClassPathBeanDefinitionScanner scanner = new ZhouyuClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });

        scanner.scan(path);

        //AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        //beanDefinition.setBeanClass(ZhouyuFactoryBean.class);
        //beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        //registry.registerBeanDefinition("userMapper", beanDefinition);
        //
        //AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        //beanDefinition2.setBeanClass(ZhouyuFactoryBean.class);
        //beanDefinition2.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
        //registry.registerBeanDefinition("orderMapper", beanDefinition2);
    }
}
