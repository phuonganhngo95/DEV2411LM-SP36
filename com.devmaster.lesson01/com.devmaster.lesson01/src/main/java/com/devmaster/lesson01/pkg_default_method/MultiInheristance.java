package com.devmaster.lesson01.pkg_default_method;

public class MultiInheristance implements Interface1, Interface2 {
    public void method1() {
        Interface1.super.method1();
        System.out.println("MultiInheristance method1");
    }

    public void method2() {
        Interface2.super.method2();
        System.out.println("MultiInheristance method2");
    }

    //    test
    public static void main(String[] args) {
        MultiInheristance mi = new MultiInheristance();
        mi.method1();
        mi.method2();
    }
}
