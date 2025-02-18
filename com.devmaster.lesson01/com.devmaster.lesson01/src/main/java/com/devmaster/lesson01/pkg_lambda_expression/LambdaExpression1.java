package com.devmaster.lesson01.pkg_lambda_expression;

@FunctionalInterface
interface SayHello1 {
    void sayHello();
}

public class LambdaExpression1 {
    public static void main(String[] args) {
        SayHello1 sayHello1 = () -> {
            System.out.println("Hello World");
        };
        sayHello1.sayHello();
    }
}
