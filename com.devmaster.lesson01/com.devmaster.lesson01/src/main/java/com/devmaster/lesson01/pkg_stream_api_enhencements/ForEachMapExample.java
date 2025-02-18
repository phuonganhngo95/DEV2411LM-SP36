package com.devmaster.lesson01.pkg_stream_api_enhencements;

import java.util.HashMap;
import java.util.Map;

public class ForEachMapExample {
    public static void main(String[] args) {
        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "Java Spring");
        hmap.put(2, "JavaScript");
        hmap.put(3, "PHP Lavarel");
        hmap.put(4, "C# NetCore");

        hmap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
