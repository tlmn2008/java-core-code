package kenny.algorithm.proxy_aop.aopexample.handlers;

import kenny.algorithm.proxy_aop.aopframe.BeforeHandler;

import java.lang.reflect.Method;

public class BeforeCalcuHandlerImpl extends BeforeHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		System.out.println("handler before method invoke");
	}
}
