package ru.vsu.cs.tarantsov;

import java.util.ArrayList;

public class SimpleDictionary {

    private Object[] arr;
    private final int arraySize = 100;
    private int count = 0;
    private ArrayList<Object> keys = new ArrayList<>();
    private ArrayList<Object> values = new ArrayList<>();

    public SimpleDictionary() {
        this.arr = new Object[arraySize];
    }

    public void put(Object key, Object value) {
        int index = key.hashCode() & (arraySize - 1);
        arr[index] = value;
        count++;
        keys.add(key);
        values.add(value);
    }

    public Object get(Object key) {
        int index = key.hashCode() & (arraySize - 1);
        return arr[index];
    }

    public void remove(Object key, Object value) {
        int index = key.hashCode() & (arraySize - 1);
        arr[index] = null;
        count--;
        keys.remove(key);
        values.remove(value);
    }

    public Object size() {
        return count;
    }

    public ArrayList<Object> keySet() {
        return keys;
    }

    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    public ArrayList<Object> valueSet(){
        return values;
    }

    
}









