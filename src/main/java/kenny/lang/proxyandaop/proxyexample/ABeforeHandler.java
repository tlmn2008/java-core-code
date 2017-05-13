package kenny.lang.proxyandaop.proxyexample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class ABeforeHandler implements InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		handleBefore(proxy, method, args);

        Object result = method.invoke(args);

        return result;
	}

    // 抽象方法
    public abstract void handleBefore(Object proxy, Method method, Object[] args);

}
