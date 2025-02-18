package com.devmaster.lesson01.pkg_lambda_expression;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java SpringBoot", "C# NetCore", "PHP", "JavaScript");
//        Lặp c1
        list.forEach(item-> System.out.println(item));

//        Lặp c2
        list.forEach(System.out::println);

//        Filter
        list.stream().filter(item->item.length()>10).forEach(System.out::println);

        list.stream().filter(x->x.toUpperCase().contains("C")).forEach(System.out::println);
    }
}
