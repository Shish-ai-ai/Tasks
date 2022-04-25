package ru.vsu.cs.tarantsov;


import java.util.Arrays;

public class Sort {
    private static void swap(int[] arr, int i1, int i2) {
        int tmp;
        tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
    public static void heapify(int[] arr, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && arr[left] > arr[largest])
            largest = left;
        if (right < size && arr[right] > arr[largest])
            largest = right;
        if (largest != index) {
            swap(arr, largest, index);
            heapify(arr, size, largest);
        }
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            Sort.heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);

        }
    }
    public static void sortFT(int[] data, int from, int to) {

        int[] newArray = Arrays.copyOfRange(data, from, to);

        for (int i = newArray.length / 2 - 1; i >= 0; i--) {
            Sort.heapify(newArray, newArray.length, i);
        }
        for (int i = newArray.length - 1; i >= 0; i--) {
            swap(newArray, 0, i);
            heapify(newArray, i, 0);
        }

        for (int i = from; i < to; i++) {
            data[i] = newArray[i - from];
        }
    }
}
