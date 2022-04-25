package ru.vsu.cs.tarantsov;

public class Main {

    public static void main(String[] args) {
        System.out.println("Standard heapSort");
        int[] arr = new int[] {1, 4, 6, 2, 7};
        Sort.sort(arr);
        for (int i: arr)
            System.out.println(i);
        System.out.println("____________________________");
        System.out.println("Modified heapSort");

        int[] data = new int[] {1, 4, 6, 2, 7, 4};
        Sort.sortFT(data, 4, 6);
        for (int i: data)
            System.out.println(i);
    }
}
