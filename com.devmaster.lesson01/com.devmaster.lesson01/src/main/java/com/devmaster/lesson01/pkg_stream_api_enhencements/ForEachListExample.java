package com.devmaster.lesson01.pkg_stream_api_enhencements;

import java.util.Arrays;
import java.util.List;

public class ForEachListExample {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java Spring", "C#", "NetCore API", "PHP Lavarel", "JavaScript");

        System.out.println("Sử dụng biểu thức Lambda:");
        languages.forEach(lang -> System.out.println(lang));

        System.out.println("\nSử dụng method references:");
        languages.forEach(System.out::println);
    }
}
