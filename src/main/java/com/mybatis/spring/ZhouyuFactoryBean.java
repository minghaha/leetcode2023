package com.mybatis.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */

public class ZhouyuFactoryBean implements FactoryBean {

    private SqlSession sqlSession;


    private Class mapperInterface;


    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }


    public ZhouyuFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        return sqlSession.getMapper(mapperInterface);
    }

    //@Override
    //public Object getObject() throws Exception {
    //    Object proxyInstance = Proxy.newProxyInstance(ZhouyuFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
    //        @Override
    //        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //            System.out.println(method.getName());
    //            return null;
    //        }
    //    });
    //
    //    return proxyInstance;
    //}

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
