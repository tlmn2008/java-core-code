package kenny.algorithm.proxy_aop.proxyexample;

import kenny.algorithm.proxy_aop.proxyexample.car.Car;
import kenny.algorithm.proxy_aop.proxyexample.car.Vehicle;

import java.lang.reflect.Proxy;

public class CarDynamicProxy {

    public static void main(String[] args) {

        Vehicle car = new Car();
        CarOperateTimeHander timeHander = new CarOperateTimeHander(car);

        Vehicle carProxy = (Vehicle) Proxy.newProxyInstance(
                car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),
                timeHander);

        carProxy.start();
        carProxy.stop();
        carProxy.forward();
        carProxy.reverse();
    }

}

