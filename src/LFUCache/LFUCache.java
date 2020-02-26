package LFUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    Map<Integer, Integer> dataMap = new HashMap();
    int capacity = 0;
    Map<Integer, Integer> countMap = new HashMap();
    Map<Integer, Set<Integer>> freqMap = new HashMap();
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!dataMap.containsKey(key)) {return -1;}
        int value = dataMap.get(key);

        int count = countMap.get(key);
        countMap.put(key, count+1);
        freqMap.get(count).remove(key);
        if(freqMap.containsKey(count+1)) {
            freqMap.get(count+1).add(key);
        } else {
            freqMap.put(count+1, new HashSet<>());
            freqMap.get(count+1).add(key);
        }

        if(freqMap.get(count).isEmpty()) {
            minFreq = count+1;
        }
        return value;
    }

    public void put(int key, int value) {
        if(dataMap.containsKey(key)) {
            return;
        }
        if(dataMap.size() == capacity) {
            int removed =  freqMap.get(minFreq).iterator().next();
            freqMap.get(minFreq).remove(removed);
            dataMap.remove(removed);
            countMap.remove(removed);
        }

        dataMap.put(key, value);
        countMap.put(key, 1);
        if(!freqMap.containsKey(1)) {
            freqMap.put(1, new HashSet<>());
        }
        freqMap.get(1).add(key);
        minFreq = 1;
    }
}
