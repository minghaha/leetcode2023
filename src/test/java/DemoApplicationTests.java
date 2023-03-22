
import com.zhouyu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }


    @Test
    public void testProxy() {

        UserService userservice = new UserService();
        Enhancer enchancer = new Enhancer();
        enchancer.setSuperclass(UserService.class);
        enchancer.setCallbacks(new Callback[] {
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("before " );
                        Object invoke = methodProxy.invoke(userservice, objects);
                        System.out.println("after");
                        return invoke;
                    }
                }
        });

        UserService userService = (UserService) enchancer.create();
        userService.test();

    }

}



































