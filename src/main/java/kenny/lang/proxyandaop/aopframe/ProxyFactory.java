package kenny.lang.proxyandaop.aopframe;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    // 传入的参数是被代理对象和相应的handler
	public static Object getProxy(Object targetObject, List<AbstractHandler> handlers) {

		if (handlers.size() > 0) {
            // 将每个handler的target object设置为被代理的对象
            // 且根据下面的逻辑，当前handler的代理对象是上一个handler持有的
            // 代理对象，所以最终生成的代理对象最终的效果会将所有的handler都
            // 串起来，这个可以从TestAopInJDK的测试结果中可以看出来
            Object proxyObject = targetObject;
			for (int i = 0; i < handlers.size(); i++) {

			    // 第一个handler内的target object是原始的target对象
				handlers.get(i).setTargetObject(proxyObject);

                // 下一个handler的target object则就是这里新生成的代理对象，
				proxyObject = Proxy.newProxyInstance(
				        targetObject.getClass().getClassLoader(),
                        targetObject.getClass().getInterfaces(),
                        handlers.get(i));
                // PS: 在这个例子中分别实现了函数调用前和调用后的两个handler，
                // 如果同时实现调用前和调用后，则只需要一个handler即可

                // 其实这里的关键还是这个 Proxy.newProxyInstance()的用法问题。

			}
			return proxyObject;

		} else { //没有任何handler时则返回原始的target object
			return targetObject;
		}

	}
}
