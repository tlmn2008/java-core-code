package kenny.algorithm.design_pattern.xbehavior.responsibility_chain.demo;

//总经理
public class GeneralHandler extends ConsumeHandler {

    public void doHandler(String user, double free) {

        if (free >=1000) {
            if (user.equals("lwxzy")) {
                System.out.println("给予报销:" + free);
            } else {
                System.out.println("报销不通过");
            }
        } else {
            if (getNextHandler() != null) {
                getNextHandler().doHandler(user, free);
            }
        }

    }
}
