
1.
JAXP和JAXB是JSR206和JSR222的实现。
后者更好用，支持XML和POJO的绑定。
JAXB包含xjc和schemagen两个工具。

2.
jaxb2-maven-plugin即JAXB
jaxb2-maven-plugin有下面两个用处：
jaxb2:xjc           :将XSD转成注解类
jaxb2:schemagen     :将注解类转成XSD

3.
XSD <------> 类
XML <------> 实例
可以用XSD（schema）来验证XML或实例对象。



























