package ru.vsu.cs.tarantsov;

public class Main {

    public static void main(String[] args) {
        SimpleDictionary hashMap = new SimpleDictionary();
        hashMap.put("Monday", "Понедельник");
        hashMap.put("Tuesday","Вторник");
        hashMap.put("Wednesday","Среда");
        hashMap.remove("Monday", "Понедельник");


        System.out.println(hashMap.get("Monday"));
        System.out.println(hashMap.get("Tuesday"));
        System.out.println(hashMap.size());
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.valueSet());
        System.out.println(hashMap.containsKey("Tuesday"));
        System.out.println(hashMap.containsKey("Monday"));
    }
}
