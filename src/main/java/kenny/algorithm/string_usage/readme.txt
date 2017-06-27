使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容的检查，
否则会有抛 IndexOutOfBoundsException 的风险。
String str = "a,b,c,,";
String[] ary = str.split(",");
System.out.println(ary.length); //预期大于 3，结果是 3