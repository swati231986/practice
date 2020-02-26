package lrucache;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {


    Map<Integer,CacheEntry> cache = new HashMap();
    PriorityQueue<Map.Entry<Integer,Long>> pq = new PriorityQueue<Map.Entry<Integer,Long>>((a, b) -> (int)(a.getValue() - b.getValue()));

    int capacity;
    int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {System.out.println(-1);return -1;}
        int result = cache.get(key).val;
        long oldTimeStamp = cache.get(key).timestamp;
        CacheEntry cacheEntry = new CacheEntry();
        cacheEntry.val = result;
        cacheEntry.timestamp = System.currentTimeMillis();
        cache.put(key, cacheEntry);
        System.out.println(result);

        Map.Entry<Integer, Long> entry = new AbstractMap.SimpleEntry<Integer, Long>(key, cacheEntry.timestamp);
        pq.add(entry);
        entry = new AbstractMap.SimpleEntry<Integer, Long>(key, oldTimeStamp);
        pq.remove(entry);
        return result;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)) {
            CacheEntry cacheEntry = cache.get(key);
            Map.Entry<Integer, Long> entry = new AbstractMap.SimpleEntry<>(key, cacheEntry.timestamp);
            pq.remove(entry);
            cache.remove(key);
            size--;
        }

         if(size>=capacity) {
            Map.Entry<Integer,Long> entry = pq.poll();
            cache.remove(entry.getKey());
            size--;
        }


        CacheEntry cacheEntry = new CacheEntry();
        cacheEntry.val = value;
        cacheEntry.timestamp = System.currentTimeMillis();
        cache.put(key, cacheEntry);
        Map.Entry<Integer, Long> entry = new AbstractMap.SimpleEntry<>(key, cacheEntry.timestamp);
        pq.add(entry);
        size++;
    }

    class CacheEntry {
        Integer val;
        long timestamp;

    }
}
