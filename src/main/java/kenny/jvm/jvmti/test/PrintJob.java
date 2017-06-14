package kenny.jvm.jvmti.test;

public class PrintJob {

    private void printHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                PrintJob printJob = new PrintJob();
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printJob.printHello();
                }
            }
        }.start();
    }

}

// 如果你希望每次printHell()被执行的时候通知你一下，在不修改代码的情况下，怎么办？
// java -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8800 -cp . test.PrintJob