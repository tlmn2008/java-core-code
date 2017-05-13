package kenny.lang.proxyandaop.aopframe;

import java.lang.reflect.Method;

public abstract class AroundHandler extends AbstractHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		handleBefore(proxy, method, args);
        // before invoke
        Object returnObject = method.invoke(targetObject, args);
        // after invoke
        handleAfter(proxy, method, args);
        return returnObject;
	}

    // abstract method
    public abstract void handleBefore(Object proxy, Method method, Object[] args);

	// abstract method
	public abstract void handleAfter(Object proxy, Method method, Object[] args);

}
