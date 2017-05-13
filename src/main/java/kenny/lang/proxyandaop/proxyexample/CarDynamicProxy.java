package kenny.lang.proxyandaop.proxyexample;

import kenny.lang.proxyandaop.proxyexample.car.Car;
import kenny.lang.proxyandaop.proxyexample.car.Vehicle;

import java.lang.reflect.Proxy;
import java.util.Date;

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

