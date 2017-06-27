package kenny.algorithm.proxy_aop.aopexample;

public class CalculatorImpl implements Calculator {

    public int calculate(int a, int b) {
    	System.out.println("CalculatorImpl : in calculate method");
        return a/b;
    }

}
