package hitcounter;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {

    int count = 0;
    Map<Integer, Integer> hitCountsByTime = new HashMap();

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!hitCountsByTime.containsKey(timestamp)) {
            hitCountsByTime.put(timestamp, 1);
            count++;
            return;
        }
        hitCountsByTime.put(timestamp, hitCountsByTime.get(timestamp) + 1);
        count = count + 1;

    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int time = timestamp - 300;
        int result = count;
        for(Map.Entry<Integer, Integer> entry:hitCountsByTime.entrySet()) {
            if(entry.getKey()<=time) {
                result = result - entry.getValue();
            }
        }

        return result;
    }
}
