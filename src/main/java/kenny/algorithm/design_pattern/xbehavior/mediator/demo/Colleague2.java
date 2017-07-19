package kenny.algorithm.design_pattern.xbehavior.mediator.demo;

public class Colleague2 extends Colleague {

    public Colleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        mediator.send(message, this);
    }

    public void Notify(String message){
        System.out.println("同事2得到消息:"+message);
    }

}
