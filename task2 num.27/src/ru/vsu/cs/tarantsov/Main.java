package ru.vsu.cs.tarantsov;

public class Main {

    public static void main(String[] args) throws DoubleLinkedList.DoubleLinkedListException {
        DoubleLinkedList<Object> list = new DoubleLinkedList<Object>();

        list.addFirst(1);
        list.addFirst(2);
        list.addByIndex(1,3);
        list.addLast(4);
        list.spoiled_Node(1);
        System.out.println("Первая проверка(испорченный список): " + list.check());
        System.out.println("------------------------------------------");

        list.removeAll();
        //System.out.println(list.size());
        list.addFirst(1);
        list.addFirst(2);
        list.addByIndex(1,5);
        list.addLast(6);
        System.out.println("Вторая проверка(правильный список): " + list.check());

    }
}
