import com.Application;
import com.service.UserService;
import com.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

    }


    @Test
    public void testProxy() {

        UserService userservice = new UserServiceImpl();
        Enhancer enchancer = new Enhancer();
        enchancer.setSuperclass(UserService.class);
        enchancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib before ");
                Object invoke = methodProxy.invoke(userservice, objects);
                System.out.println("cglib  after");
                return invoke;
            }
        }});

        UserService userService = (UserService) enchancer.create();
        userService.test();

    }


    @Test
    public void testJdkProxy() {
        UserServiceImpl target = new UserServiceImpl();
        Object proxy = Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk before ");
                Object invoke = method.invoke(target, args);
                System.out.println("jdk  after");
                return invoke;
            }
        });

        UserService userService = (UserService) proxy;
        userService.test();

    }


    @Test
    public  void testProxyFactory() {

        UserServiceImpl userServiceImpl = new UserServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(userServiceImpl);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("proxyFactory.before");
            }
        });

        UserServiceImpl proxy = (UserServiceImpl) proxyFactory.getProxy();
        proxy.test();


    }

    @Resource
    @Qualifier("oneDataSource")
    DataSource oneDataSource;

    @Resource
    @Qualifier("twoDataSource")
    DataSource twoDataSource;

    @Resource
    UserService userService;

    @Test
    public void dataSource() throws SQLException {
        userService.test();


        System.out.println(oneDataSource);
        System.out.println(twoDataSource);

    }

}



































