package com.devmaster.lesson01.pkg_method_ref;

@FunctionalInterface
interface ExecuteFunction {
    public int execute(int a, int b);
}

class MathUtils {
    public MathUtils()  {}

    public MathUtils(String str) {
        System.out.println("MathUtils: " + str);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DemoMethodRef {
    public static int doAction(int a, int b, ExecuteFunction func) {
        return func.execute(a, b);
    }

    public static void main(String[] args) {
        int a = 10, b = 20;

        int sum = doAction(a, b, MathUtils::sum);
        System.out.println(a + " + " + b + " = " + sum);

        int minus = doAction(a, b, MathUtils::minus);
        System.out.println(a + " - " + b + " = " + minus);

        MathUtils math = new MathUtils();
        int mul = doAction(a, b, math::multiply);
        System.out.println(a + " + " + b + " = " + mul);
    }
}
