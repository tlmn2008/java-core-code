package kenny.lang.proxyandaop.proxyexample;

import kenny.lang.proxyandaop.proxyexample.car.Vehicle;

import java.util.Date;

public class CarStaticProxy implements Vehicle {

    private Vehicle vehicle;

    public CarStaticProxy(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void start() {
        System.out.println("Car started at " + new Date());
        this.vehicle.start();
    }

    public void stop() {
        System.out.println("Car stopped at " + new Date());
        this.vehicle.stop();
    }

    public void forward() {
        System.out.println("Car forwarded at " + new Date());
        this.vehicle.forward();
    }

    public void reverse() {
        System.out.println("Car reversed at " + new Date());
        this.vehicle.reverse();
    }

}

// 静态代理分离了代理逻辑，但存在问题：
//
//        哪天Vehicle要加更多的方法进来，CarProxy不也要跟着加代码？
//        CarProxy里的代理逻辑看起来不重复吗？
//        如果其它的类，也需要如此的代理逻辑，重新给他们写个代理类吗？
//
