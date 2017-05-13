package kenny.lang.proxyandaop.aopexample.handlers;

import kenny.lang.proxyandaop.aopframe.AfterHandler;

import java.lang.reflect.Method;


public class AfterCalcuHandlerImpl extends AfterHandler {

	@Override
	public void handleAfter(Object proxy, Method method, Object[] args) {
		System.out.println("handler after method invoke");
	}

}
