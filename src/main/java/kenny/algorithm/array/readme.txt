使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
体现的是适配器模式，只是转换接口，后台的数据仍是数组。
    String[] str = new String[] { "a", "b" };
    List list = Arrays.asList(str);
第一种情况：list.add("c"); 运行时异常。
第二种情况：str[0]= "gujin"; 那么 list.get(0)也会随之修改。