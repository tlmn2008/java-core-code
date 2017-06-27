
【强制】
获取当前毫秒数：
System.currentTimeMillis(); 而不是 new Date().getTime();
如果想获取更加精确的纳秒级时间值，用 System.nanoTime。
在 JDK8 中，针对统计时间等场景，推荐使用 Instant 类。


【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须加锁，或者使用 DateUtils 工具类。
正例：注意线程安全，使用 DateUtils。亦推荐如下处理：
private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
@Override
protected DateFormat initialValue() {
return new SimpleDateFormat("yyyy-MM-dd");
}
};
说明：如果是 JDK8 的应用，可以使用 instant 代替 Date，Localdatetime 代替 Calendar，
Datetimeformatter 代替 Simpledateformatter，官方给出的解释：simple beautiful strong
immutable thread-safe。