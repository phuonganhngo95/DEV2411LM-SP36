package com.devmaster.lesson01.pkg_lambda_expression;

@FunctionalInterface
interface SayHello2 {
    public void sayHello(String name);
}

public class LambdaExpression2 {
    public static void main(String[] args) {
//        Lambda đã sử dụng 1 tham số
        SayHello2 say1 = (name)-> {
            System.out.println("Hello " + name);
        };
        say1.sayHello("Devmaster");

        //    Ngắn gọn
        SayHello2 say2 = name -> {
            System.out.println("Hello " + name);
        };

    //    Ngắn gọn hơn
        SayHello2 say3 = name -> System.out.println("Hello " + name);
        say3.sayHello("Devmaster");
    }
}
