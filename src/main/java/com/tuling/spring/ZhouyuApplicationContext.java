package com.tuling.spring;

import org.springframework.beans.factory.InitializingBean;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2023/4/10.
 *
 * @author lichuanming
 */
public class ZhouyuApplicationContext {

    private Class configClass;

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private Map<String, Object> singletonMap = new HashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public ZhouyuApplicationContext() {

    }

    public ZhouyuApplicationContext(Class configClass) {
        this.configClass = configClass;
        scan(configClass);


    }


    void scan(Class configClass) {
        //扫描bean路径
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();
            System.out.println("path: " + path);
            path = path.replace(".", "/");  //     com/zhouyu/service

            ClassLoader classLoader = ZhouyuApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    String absolutePath = f.getAbsolutePath();

                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    absolutePath = absolutePath.replace("\\", ".");
                    System.out.println("absolutePath: " + absolutePath);


                    try {
                        Class<?> clazz = classLoader.loadClass(absolutePath);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(clazz);

                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor instance = (BeanPostProcessor) clazz.getConstructor().newInstance();
                                beanPostProcessorList.add(instance);
                            }

                            Component componentAnnotation = clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            if ("".equals(beanName)) {
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            } else {
                                //
                            }

                            if (clazz.isAnnotationPresent(Scpoe.class)) {
                                Scpoe scopeAnnotation = clazz.getAnnotation(Scpoe.class);
                                String value = scopeAnnotation.value();
                                if (value != null) {
                                    beanDefinition.setScpoe(value);
                                } else {
                                    beanDefinition.setScpoe("singleton");
                                }
                            } else {
                                beanDefinition.setScpoe("singleton");
                            }

                            beanDefinitionMap.put(beanName, beanDefinition);
                        }


                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.get(beanName) == null) {
            return null;
        }

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        Object o = null;
        String scpoe = beanDefinition.getScpoe();
        if ("singleton".equals(scpoe)) {
            o = singletonMap.get(beanName);
            if (o == null) {
                o = createBean(beanName, beanDefinition);
                singletonMap.put(beanName, o);
            }

        } else {
            o = createBean(beanName, beanDefinition);
        }

        return o;

    }

    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object object = null;
        try {
            object = beanDefinition.getType().getConstructor().newInstance();



            Class clazz = beanDefinition.getType();
            for (Field declaredField : clazz.getDeclaredFields()) {
                if(declaredField.isAnnotationPresent(AutoWired.class)){
                    declaredField.setAccessible(true);
                    declaredField.set(object,getBean(declaredField.getName()));
                }
            }


            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                object = beanPostProcessor.postProcessAfterInitialization(object, beanName);
            }



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return object;
    }

}
