Java内置有3中注解：@override, @deprecated, @suppresswarning (定义在java.lang中，另外定义了4种元注解)

定义一个注解时，其实就是定义了一个接口。
例如：@UserAnnotation 在使用注解时相当于实例化了一个代理注解类，其中存储了相应的注解参数。
$Proxy0 extends java.lang.refect.Proxy implements UserAnnotation









