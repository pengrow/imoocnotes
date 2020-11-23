[TOC]

# java学习笔记

## java基础

### 注释

### 数据类型

### 变量

### 运算符

### 流程控制

## 多线程详解

### 基本概念

多任务，生活中有很多这样的例子，比如开车的同时打电话，上厕所同时玩手机

多线程，相比单独线程，执行效率高。实际同一时刻是一个线程在执行，但是由于切换时间很短，感知不到，就跟多个线程任务在同时并行执行一样。

进程，一个进程可以有多个线程。

Process和Thread，程序是静态概念，指的是代码文件，进程是程序运行时的动态概念。一个播放器在运行时就是一个进程，通过多个线程分别完成图像、声音处理。

### 多线程创建

- 继承Thread类

- 实现Runnable接口

- 实现Callable接口

  
  
## 线程同步

队列，锁

synchronized



### 同步方法

synchronized方法和synchronized块

synchronized方法缺点：若将一个大的方法声明为synchronized将会影响效率。方法里面需要修改的内容才需要锁，锁太多浪费资源。



## 死锁

产生死锁的四个必要条件：

1. 互斥条件：一个资源每次只能被一个进程使用
2. 请求与保持条件：已获得的资源保持不放
3. 不剥夺条件：进程已获得的资源，在未使用完之前不会强行剥夺
4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系



# 《Java多线程编程实战指南》

## 走近Java世界中的线程

run方法是线程的入口, start方法是启动线程。但是并不是start方法调用结束就意味着线程开始运行，这个线程有可能稍后才被运行，也有可能永远不会被运行。

在Java平台中，一个线程就是一个对象，创建对象就会分配内存空间，Java虚拟机会为每个线程分配调用栈所需的内存空间。调用栈用于跟踪Java代码（方法）间的调用关系以及Java代码对本地代码的调用。





# 注解与反射

## 什么是注解

Annotation是从JDK5.0开始引入的新技术

Annotation的作用：

- 不是程序本身，可以对程序做出解释

- 可以被其他程序（比如编译器等）读取

格式：

- @注释名

在哪里使用：
- 附加在package,class,method,field等上面，相当于给他们添加了额外的辅助信息，可以通过反射机制编程实现对这些元数据的访问

##内置注解

@Deprecated  修饰方法，属性，类，表示不鼓励程序员使用这样的元素

@Override 修饰方法，表示一个方法声明打算重写超累中的另一个方法

@SuppressWarnings  用来抑制编译时的警告信息。需要添加一个参数才能正确使用，参数都是已经定义好的

## 元注解

元注解的作用就是注解其他注解，Java定义了4个标准的meta-annotation类型，他们被用来提供对其他annotation类型作说明

@Target, 

@Retention,  描述注解的生命周期 SOURCE<CLASS<RUNTIME

@Document, 说明该注解将被包含在javadoc中

 @Inherited 说明子类可以继承父类中的该注解

## 自定义注解

## 反射

静态语言&动态语言

Reflection（反射）是Java被视为动态语言的关键，反射机制允许程序在执行期间借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。

![image-20201012004446853](/Users/lipeng/Library/Application Support/typora-user-images/image-20201012004446853.png)

应用

1. 在运行时判断任意一个对象所属的类
2. 在运行时判断任意一个类的对象
3. 在运行时判断任意一个类所具有的成员变量和方法
4. 在运行时获取泛型信息
5. 在运行时调用任意一个对象的成员变量和方法
6. 在运行时处理注解
7. 生成动态代理

优点和缺点

优点：可以实现动态创建对象和编译，体现出很大的灵活性

缺点：对性能有影响。反射是一种解释操作，慢于直接执行相同的操作

相关的主要API

- java.lang.Class: 代表一个类

- Java.lang.reflect.Method: 代表类的方法

- java.lang.reflect.Field: 代表类的成员变量

- java.lang.reflect.Constructor: 代表类的构造器

- ……

## 类加载内存

## 类初始化

![image-20201013002842096](/Users/lipeng/Library/Application Support/typora-user-images/image-20201013002842096.png)

## 类加载器

![image-20201013003005166](/Users/lipeng/Library/Application Support/typora-user-images/image-20201013003005166.png)

系统，扩展，引导类

![image-20201013003048417](/Users/lipeng/Library/Application Support/typora-user-images/image-20201013003048417.png)

## 类的运行时结构

通过反射获取运行时类的完整结构

Field, Method, Constructor, Superclass, Interface, Annotation






# 思考

进程VS线程，资源：内存空间、文件句柄

多线程编程 VS 并发编程

多线程调试

java开发工具类

JVM



# Java8

  Java8是2014年由Oracle发布的一个版本，又称之为jdk1.8，是现在我们在工作中最常见的一个版本。

在jdk1.8中，java添加了比较多的新特性，是自Java诞生以来最大的改变。本次演练，我们将挑选Java8最核心的一些特性来练习。主要有：

希望通过本次演练，能够掌握java8新特性的基本用法，提升开发效率，更高阶的技巧可以在后续的工作过程中逐步去解锁。



## 默认方法

默认方法是什么

 默认方法就是接口里面可以有实现的方法，并且不需要实现类去实现其方法。并且默认方法允许你添加新的方法到现在的接口中，并且确保与旧版本的兼容性。

​    默认方法的出现是因为在java8设计的过程中，因为加入了Lamdba表达式，和函数式接口，所以在非常多的接口里面要加入新的方法，但是如果在接口里面直接加入新的方法，那么以前写的所有的当前接口的现在类，全部都要加上新的实现。那么这对以前等于说就不兼容了，所以当时就产生了默认方法（Default Methods)，默认方法就是为了解决这个问题的。

​    默认方法就是在接口签名前面加入default关键字就是默认方法了。



```java

//Iterable类里面的默认方法
default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}

```





时间，日期API先不介绍

## Lambda表达式

lambda是一个匿名函数，可以把lambda表达式理解为一段可以传递的代码（将代码像数据一样进行传递），使用它可以写出更简洁、更灵活的代码。

### 表达式形式

- 无参数，无返回值

- 无参数，有返回值

- 有参数，无返回值

- 有参数，有返回值

  



## 函数式接口

函数式接口是一种特殊的接口，但是它还是一个接口，只是有些特殊罢了。

函数式接口的出现主要是为了配合Lambda表达式来使用。

- 接口中只有一个抽象方法

- 接口上面可以加一个注解*@FunctionalInterface*来检查接口中的方法是不是只有一个抽象方法

- 在接口里面可以加入默认方法和静态方法
- 函数式接口重写父类的方法，并不会计入到自己的抽象类方法中

```java

//加入这个注解是为了检测接口中是否符合函数式接口的要求
@FunctionalInterface
public interface MyFunctionInterction {
    //唯一的抽象方法
    void absoluMethod();

    //重写Object的方法
    @Override
    String toString();

    //默认方法
    default void defaultMethod() {
        System.out.println("默认方法");
    }

    //静态方法
    static void stativMethod() {
        System.out.println("静态方法");
    }
}
```



函数式接口简单实用



Java8里面自定义的四个核心函数式接口

https://www.cnblogs.com/xdtg/p/11986698.html

![img](https://img2018.cnblogs.com/blog/1609645/201912/1609645-20191205013008866-1483620368.png)



## 方法引用于构造器引用



## Stream API

​    集合是Java中使用最多的API，几乎每一个Java程序都会制造和处理集合。集合对于很多程序都是必须的，但是如果一个集合进行，分组，排序，筛选，过滤...这些操作，会感到非常的难受，所以我们在连接数据库，处理数据时，数据能在sql中处理就在sql中处理，不能的就在java程序中处理，最后没有办法了才在页面中处理。
  这个为什么呢？因为使用sql语句中处理数据，真的非常的简单。如果把数据取出来，在程序中用集合处理，用循环会非常的麻烦。所以java在**Java8里面加入了Steam()**，为了就是处理集合的时候，就象写sql语句一样简单。

元素在经过中间操作以后，最后有终端操作来进行收集，可以变成你想要的任何类型的数据。比如：收集成 List，Set，Map，Array...



### 创建Stream



### 中间操作







## Optional类

Optional类，可以减少被null检查的代码污染。





# 996

## 函数编程演变史

实战：

根据实际场景，应对不断变化，代码多个版本演进





汇总和规约，并行涉及线程和原子性，使用JDK封装的，不建议自定义汇总和规约，一次不行就两次

收集器接口Collect



首先建立数据模型

然后初始化数据

尝试

对比

案例一

班级中有20名学生，每名学生有5门课的考试成绩。其中缺考的科目分数字段为空。需要找出有缺考的学生都叫什么名字



案例二

标签管理功能模块。允许用户批量添加标签，后台需要对标签进行去重，并且需要防止数据库中存在同名的标签



案例三

权限管理功能模块。查询某用户所有角色下所包含的权限名称。





(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
(2) 交易员都在哪些不同的城市工作过？
(3) 查找所有来自于剑桥的交易员，并按姓名排序。
(4) 返回所有交易员的姓名字符串，按字母顺序排序。
(5) 有没有交易员是在米兰工作的？
(6) 打印生活在剑桥的交易员的所有交易额。
(7) 所有交易中，最高的交易额是多少？
(8) 找到交易额最小的交易。









推荐资料

《Java8实战》

https://www.cnblogs.com/xdtg/p/11979181.html

https://www.cnblogs.com/flydean/p/12680373.html

https://developer.ibm.com/zh/articles/j-lo-java8streamapi/

https://www.cnblogs.com/1446358788-qq/archive/2004/01/13/12873911.html






















