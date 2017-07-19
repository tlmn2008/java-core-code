package kenny.algorithm.design_pattern.xbehavior.mediator.demo;


public class Test {

    public static void main(String[] args) {

        ConcreteMediator mediator=new ConcreteMediator();

        Colleague1 colleague1=new Colleague1(mediator);
        Colleague2 colleague2=new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("最近还好吗？");
        colleague2.send("还不错");

    }
}
