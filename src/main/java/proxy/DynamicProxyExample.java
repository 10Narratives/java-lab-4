package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Service {
    void doWork();
}

class RealService implements Service {
    public void doWork() {
        System.out.println("Real work");
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        Service realService = new RealService();

        Service proxyService = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before work");
                        Object result = method.invoke(realService, args);
                        System.out.println("After work");
                        return result;
                    }
                }
        );

        proxyService.doWork();
    }
}