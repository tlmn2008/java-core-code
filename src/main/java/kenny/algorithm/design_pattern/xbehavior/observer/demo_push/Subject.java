package kenny.algorithm.design_pattern.xbehavior.observer.demo_push;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    // 用来保存注册的观察者对象
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer){
        list.add(observer);
        System.out.println("attach an observer");
    }
    public void detach(Observer observer){
        list.remove(observer);
        System.out.println("detach an observer");
    }

    // 通知所有注册的观察者对象
    public void nodifyObservers(String newState){
        for(Observer observer : list){
            observer.update(newState);
        }
    }
}
