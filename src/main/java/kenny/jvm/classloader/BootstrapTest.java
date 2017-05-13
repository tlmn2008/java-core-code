package kenny.jvm.classloader;

import java.net.URL;

// 根类加载器非常特殊，它并不是java.lang.ClassLoader的子类，而是JVM实现的。
// 下面的程序可以获得根类加载器所加载的核心类库。

// Extension ClassLoader则负责加载jre/lib/ext或由java.ext.dirs指定的目录中的jar或类。

// System ClassLoader则负责jvm启动时，加载由Java命令-classpath选项，java.class.path系统属性或CLASSPATH环境变量
// 所指定的jar或类。可以通过ClassLoader的静态方法getSystemClassLoader()来获取System ClassLoader。

public class BootstrapTest {

    public static void main(String[] args){
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }
}

// test results:

//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/resources.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/rt.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/sunrsasign.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jsse.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jce.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/charsets.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jfr.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/classes