推模型和拉模型
在观察者模式中，又分为推模型和拉模型两种方式。

两种模式的比较
推模型是假定主题对象知道观察者需要的数据；
而拉模型是主题对象不知道观察者具体需要什么数据，没有办法的情况下，干脆把自身传递给观察者，让观察者自己去按需要取值。


在JAVA语言的java.util库里面，提供了一个Observable类以及一个Observer接口，构成JAVA语言对观察者模式的支持。