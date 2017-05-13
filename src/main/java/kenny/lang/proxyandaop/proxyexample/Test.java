package kenny.lang.proxyandaop.proxyexample;

import kenny.lang.proxyandaop.aopexample.Calculator;
import kenny.lang.proxyandaop.aopexample.CalculatorImpl;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {

        ABeforeHandlerImpl handler = new ABeforeHandlerImpl();

        // get proxy
        CalculatorImpl calcImpl = new CalculatorImpl();


		Calculator calcproxy = (Calculator) Proxy.newProxyInstance(
		        calcImpl.getClass().getClassLoader(),
                calcImpl.getClass().getInterfaces(),
                handler);

		int result = calcproxy.calculate(20, 10);
		System.out.println("\nFInal Result = " + result);

        // test result:
        // handler around before method invoke
        // handler after method invoke
        // CalculatorImpl : in calculate method
        // handler before method invoke
        // handler around after method invoke

//        AroundHandler aroundHandler = new AroundHandlerImpl();
//
//        Calculator calcproxy2 = (Calculator) Proxy.newProxyInstance(
//                calcImpl.getClass().getClassLoader(),
//                calcImpl.getClass().getInterfaces(),
//                aroundHandler);
//
//        int result2 = calcproxy2.calculate(20, 10);
//        System.out.println("\nFInal Result2 = " + result2);

//        proxyObject = Proxy.newProxyInstance(
//                targetObject.getClass().getClassLoader(),
//                targetObject.getClass().getInterfaces(),
//                handlers.get(i));

	}

}
