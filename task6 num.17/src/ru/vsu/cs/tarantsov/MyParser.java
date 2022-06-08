package ru.vsu.cs.tarantsov;


public class MyParser {

        public static SimpleHashMap<String, Integer> getAbbreviation(String text, SimpleHashMap<String, Integer> dict) {
                String[] t = text.split(" ");
                for (int i = 0; i < t.length; i++) {
                        if (t[i].equals(t[i].toUpperCase()) && t[i].length() >= 2 && t[i].length() <= 5 && !Parser.isNumeric(t[i])) {
                                if (!dict.containsKey(t[i]))
                                        dict.put(t[i], 1);
                                else
                                        dict.put(t[i], dict.get(t[i]) + 1);
                        }
                }
                return dict;
        }
}