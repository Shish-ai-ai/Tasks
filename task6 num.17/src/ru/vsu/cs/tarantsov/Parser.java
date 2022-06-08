package ru.vsu.cs.tarantsov;

import java.util.Map;

public class Parser {

    public static Map<String, Integer> getAbbreviation(String text, Map<String, Integer> map) {
        String[] t = text.split(" ");
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(t[i].toUpperCase()) && t[i].length() >= 2 && t[i].length() <= 5 && !Parser.isNumeric(t[i])) {
                if (!map.containsKey(t[i]))
                    map.put(t[i], 1);
                else
                    map.put(t[i], map.get(t[i]) + 1);
            }
        }
        return map;
    }

    public static String cleanText(String text) {
        String punctuations = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~-–";
        for (int i = 0; i < punctuations.length(); i++) {
            text = text.replace((String.valueOf(punctuations.charAt(i))),"");
        }
        text = text.replace("\n", " ");

        return text;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {

            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }
}
