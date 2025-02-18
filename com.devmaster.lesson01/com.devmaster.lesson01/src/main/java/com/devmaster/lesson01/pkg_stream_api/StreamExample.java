package com.devmaster.lesson01.pkg_stream_api;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    List<Integer> intergerList = Arrays.asList(11, 22, 55, 33, 44, 66);

    public void withoutStream() {
        int count = 0;
        for (Integer integer : intergerList) {
            if (integer % 2 == 0) {
                count++;
            }
        }
        System.out.println("Số phần tử chẵn: " + count);
    }

    public void withStream() {
        long count = intergerList.stream().filter(num->num % 2 == 0).count();
        System.out.println("\nSố phần tử chẵn: " + count);
    }

    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        streamExample.withoutStream();
        streamExample.withStream();
    }
}
