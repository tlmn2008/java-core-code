package kenny.algorithm.proxy_aop.aopframe;

import java.lang.reflect.Method;

public abstract class AfterHandler extends AbstractHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

	    // before invoke
		Object result = method.invoke(targetObject, args);
        // after invoke
		handleAfter(proxy, method, args);
		return result;
	}

    // abstract method
    public abstract void handleAfter(Object proxy, Method method, Object[] args);

}
