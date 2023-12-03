package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> wordMap = mapOfWords(lines);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());

        entries.sort(new WordEntryComparator());

        int counter = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            result.append(entry.getKey()).append(" - ").append(entry.getValue());
            counter++;
            if(counter < wordMap.size()) result.append("\n");
        }
        return result.toString();
    }

    private HashMap<String, Integer> mapOfWords(List<String> lines) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String line : lines) {
            String regex = "[\"\\s-‘/'’”“$&+,:;=?@#|<>.^*()%!—-]";
            String[] wordList = line.split(regex);
            for (String word: wordList) {
                map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }
        HashMap<String, Integer> ommitedMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (key.length() >= 4 && map.get(key) >= 10) {
                ommitedMap.put(key, map.get(key));
            }
        }
        return ommitedMap;
    }
}
