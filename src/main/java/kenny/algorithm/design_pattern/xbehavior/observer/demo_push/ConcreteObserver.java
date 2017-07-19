package kenny.algorithm.design_pattern.xbehavior.observer.demo_push;

public class ConcreteObserver implements Observer {

    private String observerState;

    public void update(String state) {
        // 更新观察者的状态，使其与目标的状态保持一致
        observerState = state;
        System.out.println("状态为："+observerState);
    }

}
