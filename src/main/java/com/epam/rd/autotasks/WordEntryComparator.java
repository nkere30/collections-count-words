package com.epam.rd.autotasks;

import java.util.Comparator;
import java.util.Map;

public class WordEntryComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        int resultByAmount = entry2.getValue().compareTo(entry1.getValue());
        return resultByAmount != 0 ? resultByAmount : entry1.getKey().compareTo(entry2.getKey());
    }
}
