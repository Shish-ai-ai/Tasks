package ru.vsu.cs.tarantsov;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> Queue = new LinkedList<>();
        for (int i = 5; i >= -5; i--) {
            Queue.add(i);
        }
        Queue = Sort.sort(Queue);
        for (Integer i: Queue)
        System.out.println(i);
    }
}
