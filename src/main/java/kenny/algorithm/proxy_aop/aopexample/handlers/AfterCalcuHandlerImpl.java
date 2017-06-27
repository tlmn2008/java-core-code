package kenny.algorithm.proxy_aop.aopexample.handlers;

import kenny.algorithm.proxy_aop.aopframe.AfterHandler;

import java.lang.reflect.Method;


public class AfterCalcuHandlerImpl extends AfterHandler {

	@Override
	public void handleAfter(Object proxy, Method method, Object[] args) {
		System.out.println("handler after method invoke");
	}

}
