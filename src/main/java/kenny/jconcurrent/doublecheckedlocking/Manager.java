package kenny.jconcurrent.doublecheckedlocking;

class Helper {
}

class Manager1 {
    private Helper helper = null;
    public Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }
}
//这段代码如果运行在多线程环境下，将会出现问题。

class Manager2 {
    private Helper helper = null;
    public synchronized Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }
}
//上面的代码在每次调用getHelper方法的时候都要进行同步

class Manager3 {
    private Helper helper = null;
    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }
}
//避免了当Helper对象被实例化之后再次进行同步
//不幸的是，这段代码在存在编译优化或多处理器共享内存的情况下不能够正常工作。


//JDK1.5或者更晚的版本中，扩展了volatile的语义，使得我们可以通过将helper属性字段设置为volatile来修复Double-Checked的问题
class ManagerOk {
    private volatile Helper helper = null;
    public Helper getHelper() {
        if (helper == null) {
            synchronized(this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }
}
