package com.lesson02.tight_loosely_coupling;

import java.util.Arrays;

@FunctionalInterface
interface SortAlgorithm {
    void sort(int[] array);
}

class BubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("Sắp xếp theo giải thuật BubbleSort:");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::println); // Print sorted array
    }
}

class SelectionSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("Sắp xếp theo giải thuật SelectionSort:");
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        Arrays.stream(array).forEach(System.out::println); // Print sorted array

    }
}


public class LooselyCoupledService {
    private SortAlgorithm sortAlgorithm;

    public LooselyCoupledService() {
        // Default sorting algorithm (e.g., BubbleSort)
        this.sortAlgorithm = new BubbleSortAlgorithm();
    }

    public LooselyCoupledService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] array) {
        sortAlgorithm.sort(array);
    }

    public static void main(String[] args) {
        LooselyCoupledService service1 = new LooselyCoupledService(); // Uses BubbleSort by default
        service1.complexBusiness(new int[] {11, 21, 13, 42, 15});

        SortAlgorithm selectionSort = new SelectionSortAlgorithm();
        LooselyCoupledService service2 = new LooselyCoupledService(selectionSort); // Inject SelectionSort
        service2.complexBusiness(new int[] {11, 21, 13, 42, 15});

        SortAlgorithm bubbleSort = new BubbleSortAlgorithm();
        LooselyCoupledService service3 = new LooselyCoupledService(bubbleSort); // Inject BubbleSort
        service3.complexBusiness(new int[] {11, 21, 13, 42, 15});
    }
}