package kenny.lang.proxyandaop.aopexample.handlers;

import kenny.lang.proxyandaop.aopframe.AroundHandler;

import java.lang.reflect.Method;

public class AroundCalcuHandlerImpl extends AroundHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		System.out.println("handler around before method invoke");
	}

	public void handleAfter(Object proxy, Method method, Object[] args) {
		System.out.println("handler around after method invoke");
	}
}
