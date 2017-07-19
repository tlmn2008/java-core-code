package kenny.algorithm.design_pattern.xbehavior.mediator.demo;

public class ConcreteMediator implements Mediator {

    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }
    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.Notify(message);
        }else{
            colleague1.Notify(message);
        }
    }
}
