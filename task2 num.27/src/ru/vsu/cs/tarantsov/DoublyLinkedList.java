package ru.vsu.cs.tarantsov;

import java.util.Iterator;

class DoubleLinkedList<T> implements Iterable<T> {

        public static class DoubleLinkedListException extends Exception {
            public DoubleLinkedListException(String message) {
                super(message);
            }
        }
        private class DoubleLinkedListNode {

        public T value;
        public DoubleLinkedListNode next;
        public DoubleLinkedListNode prev;

        public DoubleLinkedListNode(T value, DoubleLinkedListNode next, DoubleLinkedListNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public DoubleLinkedListNode(T value) {
            this(value, null, null);
        }
    }

    private DoubleLinkedListNode head = null;
    private DoubleLinkedListNode tail = null;
    private int size = 0;

    private void checkEmptyError() throws DoubleLinkedListException {
        if (size == 0) {
            throw new DoubleLinkedListException("Empty list");
        }
    }

    private DoubleLinkedListNode getNode(int index) {
        DoubleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }


    public void addFirst(T value) {
        DoubleLinkedListNode old_head = head;
        head = new DoubleLinkedListNode(value, head, null);
        if (old_head != null)
            old_head.prev = head;
        size++;
        if (size == 1) {
            tail = head;
        }
    }

    public void addByIndex(int index, T value) {
        DoubleLinkedListNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        DoubleLinkedListNode temp = new DoubleLinkedListNode(value);
        curr.prev.next = temp;
        temp.prev = curr.prev;
        curr.prev = temp;
        temp.next = curr;
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new DoubleLinkedListNode(value);
        } else {
            tail.next = new DoubleLinkedListNode(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    public void removeFirst() throws DoubleLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void removeLast() throws DoubleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) throws DoubleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new DoubleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            DoubleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public void removeAll() throws DoubleLinkedListException {
        checkEmptyError();
        head = null;
        tail = null;
        size = 0;
    }

    public T get(int index) throws DoubleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    public T getFirst() throws DoubleLinkedListException {
        checkEmptyError();
        return head.value;
    }

    public T getLast() throws DoubleLinkedListException {
        checkEmptyError();
        return tail.value;
    }

    public int size(){
        return size;
    }

    public void getAll() throws DoubleLinkedListException {
        checkEmptyError();
        DoubleLinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public boolean check() {
        DoubleLinkedListNode curr = head;
        while (curr != tail) {
            DoubleLinkedListNode nextNode = curr.next;
            if (nextNode.prev != curr) {
                return false;
            }
            curr = nextNode;
        }
        return true;
    }

    public void spoiled_Node(int id) {
        DoubleLinkedListNode node = getNode(id);
        node.prev = null;
    }





    @Override
    public Iterator<T> iterator() {
        class DoubleLinkedListIterator implements Iterator<T> {
            DoubleLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new DoubleLinkedListIterator();
    }

}


