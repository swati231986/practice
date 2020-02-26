package time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Data>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }

    public void set(String key, String value, int timestamp) {
        if(key == null || key == "") {return;}
        Data data = new Data();
        data.value =value;
        data.timestamp = timestamp;

        if(map.containsKey(key)) {
            map.get(key).add(data);
        } else {
            List<Data> list = new ArrayList();
            list.add(data);
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if(key == null || key == "") {return null;}
        if(!map.containsKey(key)) {return  null;}
        int result = binarySearch(map.get(key) , 0, map.get(key).size()-1, timestamp);
        if(result == -1) {return "";}
        return map.get(key).get(result).value;

    }

    private int binarySearch(List<Data> list, int low, int high, int target) {
        if(low < 0 || low >= list.size() || high < 0 || high >= list.size()) {return -1;}
        if(low > high) {
            if(list.get(low).timestamp < target) {
                return low;
            } else {return high;}
        }

        int mid = (low + high)/2;

        Data dataMid = list.get(mid);
        if(dataMid.timestamp  == target) {return mid;}

        if(dataMid.timestamp < target) {
            if(mid + 1 >= list.size() ) {
                return mid;
            } else if(list.get(mid + 1).timestamp > target) {
                return mid;
            } else {
                return binarySearch(list, mid+1, high, target);
            }
        } else {
            return binarySearch(list, low, mid-1, target);
        }
    }
}
