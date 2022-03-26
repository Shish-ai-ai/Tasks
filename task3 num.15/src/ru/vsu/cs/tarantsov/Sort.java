package ru.vsu.cs.tarantsov;

import java.util.LinkedList;

public class Sort {
    public static LinkedList<Integer> sort(LinkedList<Integer> Queue) {
        LinkedList<Integer> QueuePositive = new LinkedList<>();
        LinkedList<Integer> QueueZero = new LinkedList<>();
        LinkedList<Integer> QueueNegative = new LinkedList<>();
        while (!Queue.isEmpty()) {
            Integer first = Queue.getFirst();
            if (first > 0)
                QueuePositive.addFirst(first);
            else if (first == 0)
                QueueZero.add(first);
            else QueueNegative.addFirst(first);
            Queue.removeFirst();
        }
        while (!QueueNegative.isEmpty()) {
            Queue.add(QueueNegative.getFirst());
            QueueNegative.removeFirst();
        }

        while (!QueueZero.isEmpty()) {
            Queue.add(QueueZero.getFirst());
            QueueZero.removeFirst();
        }

        while (!QueuePositive.isEmpty()) {
            Queue.add(QueuePositive.getFirst());
            QueuePositive.removeFirst();
        }

        return Queue;
    }
}
