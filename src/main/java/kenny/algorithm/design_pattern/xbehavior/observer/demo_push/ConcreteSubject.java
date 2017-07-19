package kenny.algorithm.design_pattern.xbehavior.observer.demo_push;

public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("current state = " + state);
        this.nodifyObservers(state);
    }
}
