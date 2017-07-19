package kenny.algorithm.design_pattern.xbehavior.responsibility_chain.demo;

public abstract class ConsumeHandler {

    private ConsumeHandler nextHandler;

    public ConsumeHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(ConsumeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void doHandler(String user, double free);
}
