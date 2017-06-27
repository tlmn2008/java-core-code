package kenny.algorithm.proxy_aop.proxyexample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class CarOperateTimeHander implements InvocationHandler {

    private Object targetObject;

    public CarOperateTimeHander(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //代理的逻辑，记录时间
        System.out.println("Car " + method.getName() + " at " + new Date());

        //调用被代理类的方法
        return method.invoke(targetObject, args);
    }
}
