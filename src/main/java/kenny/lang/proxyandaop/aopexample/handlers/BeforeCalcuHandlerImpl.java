package kenny.lang.proxyandaop.aopexample.handlers;

import kenny.lang.proxyandaop.aopframe.BeforeHandler;

import java.lang.reflect.Method;

public class BeforeCalcuHandlerImpl extends BeforeHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		System.out.println("handler before method invoke");
	}
}
