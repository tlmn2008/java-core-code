package kenny.algorithm.design_pattern.xbehavior.mediator.demo;

public class Colleague1 extends Colleague {

    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        mediator.send(message, this);
    }

    public void Notify(String message){
        System.out.println("同事1得到消息:"+message);
    }
}
