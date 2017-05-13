package kenny.lang.proxyandaop.aopexample;

import kenny.lang.proxyandaop.aopexample.handlers.AfterCalcuHandlerImpl;
import kenny.lang.proxyandaop.aopexample.handlers.AroundCalcuHandlerImpl;
import kenny.lang.proxyandaop.aopexample.handlers.BeforeCalcuHandlerImpl;
import kenny.lang.proxyandaop.aopframe.*;

import java.util.ArrayList;
import java.util.List;

public class TestCalcuAop {

	public static void main(String[] args) {

	    // create handlers
        List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();

		BeforeHandler beforeHandler = new BeforeCalcuHandlerImpl();
		AfterHandler afterHandler = new AfterCalcuHandlerImpl();
        AroundHandler aroundHandler = new AroundCalcuHandlerImpl();

		handlers.add(beforeHandler);
		handlers.add(afterHandler);
        handlers.add(aroundHandler);

        // calculatorProxy is the proxy of calculator
		Calculator calculator = new CalculatorImpl();
		Calculator calculatorProxy = (Calculator) ProxyFactory.getProxy(calculator, handlers);

		int result = calculatorProxy.calculate(20, 10);
		System.out.println("\nFInal Result = " + result);

	}

}

// test result:
// handler around before method invoke
// handler after method invoke
// CalculatorImpl : in calculate method
// handler before method invoke
// handler around after method invoke