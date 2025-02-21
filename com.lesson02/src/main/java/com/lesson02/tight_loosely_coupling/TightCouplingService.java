package com.lesson02.tight_loosely_coupling;

import java.util.Arrays;

class bubblesortalgorithm {
    public void sort(int[] arr) {
        System.out.println("Sắp xếp theo giải thuật BubbleSort:");
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}

public class TightCouplingService {
    private bubblesortalgorithm bubbleSortAlgorithm = new bubblesortalgorithm();

    public TightCouplingService() {}

    public TightCouplingService(bubblesortalgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    public void complexBusinessSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TightCouplingService tCoutingService = new TightCouplingService();
        tCoutingService.complexBusinessSort(new int[] {11, 21, 13, 42, 15});
    }
}
