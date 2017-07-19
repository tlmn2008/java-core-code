package kenny.algorithm.design_pattern.xbehavior.responsibility_chain.demo;


//项目经理
public class ProjectHandler extends ConsumeHandler {

    public void doHandler(String user, double free) {

        if (free < 500) {
            if (user.equals("lwx")) {
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
