package com.part3;

public class Test3 {
    @FieldInject(name = "chenyu")
    private  String name;

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        ReflexUtils.reflex(test3);
        System.out.println(test3.name);
    }


    @MethodInject(id = 1, print = "word")
    private void show(String print) {
        System.out.println("执行了-->>" + print);
    }
//    @MethodInject(id = 2, print = "android")
//    private void show(String print,String print2) {
//        System.out.println("执行了-->>" + print+" "+print2);
//    }
}
