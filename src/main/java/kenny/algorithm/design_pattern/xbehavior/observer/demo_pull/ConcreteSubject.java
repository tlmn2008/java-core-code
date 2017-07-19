package kenny.algorithm.design_pattern.xbehavior.observer.demo_pull;

public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("state = " + state);
        this.nodifyObservers();
    }

}
