package kenny.lang.proxyandaop.aopframe;

import java.lang.reflect.Method;

public abstract class BeforeHandler extends AbstractHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		handleBefore(proxy, method, args);
        // before invoke
        Object result = method.invoke(targetObject, args);
        // after invoke
        return result;
	}

    // abstract method
    public abstract void handleBefore(Object proxy, Method method, Object[] args);

}
