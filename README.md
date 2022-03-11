# ReflexDemo
反射demo

**包名、类名**

  
      类名name:com.part1.bean.Student
      包名: package com.part1
      父类：class com.part1.bean.People
      父类是不是抽象类：false
      父类实现的接口：interface java.lang.Runnable


**构造器**

    父类的构造器:public com.part1.bean.People(java.lang.String,int)
    父类的构造器:public com.part1.bean.People(int)
    父类的构造器:public com.part1.bean.People(java.lang.String)
    父类的构造器:public com.part1.bean.People()
    构造器方法:public com.part1.bean.People(java.lang.String,int)
    得到的结果People [name=wangbei, age=24]


## **只能拿到公有的变量或方法**

**变量**

    变量为:public java.lang.String com.part1.bean.People.love
    变量名:love
    变量为:public java.lang.String com.part1.bean.People.love
    变量名:love
    1.初始化姓名:baobei
    2.姓名:chenyu
    3.姓名:wangbei


**方法**

    --方法--:run
    --方法--:toString
    --方法--:getName
    --方法--:setName
    --方法--:setAge
    --方法--:getAge
    --方法--:wait
    --方法--:wait
    --方法--:wait
    --方法--:equals
    --方法--:hashCode
    --方法--:getClass
    --方法--:notify
    --方法--:notifyAll
    方法名为:setAge
    返回值类型为:void


**私有变量或私有方法**

    getDeclaredFields()
    getDeclaredMethods()
    getDeclaredField(变量名)
    getDeclaredMethod(方法名)
    必须让这些对象调用setAccessible(true)才能调用


**注解**

    注解测试：类---25---class com.part1.bean.People
    注解测试：类---25---class com.part1.bean.People

·················

     @com.part1.anno.MyAnnotation2(name=MyAnnotation2, weight=50, gid=class com.part1.bean.People)

    注解测试：MyAnnotation1---3---class com.part1.bean.Student

---

      MyAnnotation2:MyAnnotation2---50---class com.part1.bean.People
      MyAnnotation1:MyAnnotation1---3---class com.part1.bean.Student

---

    MyAnnotation1
    MyAnnotation2

**数组**

    int[]
    反射后数组:wangbei0
    反射后数组:wangbei1
    反射后数组:wangbei2
    反射后数组:wangbei3
