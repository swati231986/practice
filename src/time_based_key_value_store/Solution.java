package time_based_key_value_store;

public class Solution {

    public static void main(String [] args) {
        TimeMap map = new TimeMap();
        /*map.set("foo", "bar", 1);
        String result = map.get("foo", 1);
        System.out.println(result);
        result = map.get("foo", 3);
        System.out.println(result);
        map.set("foo", "bar2", 4);
        result = map.get("foo", 4);
        System.out.println(result);
        result = map.get("foo", 5);
        System.out.println(result);*/
        map.set("love", "high", 10);
        map.set("love", "low", 20);
        String result = map.get("love", 5);
        System.out.println(result);
        result = map.get("love", 10);
        System.out.println(result);
        result = map.get("love", 15);
        System.out.println(result);
        result = map.get("love", 20);
        System.out.println(result);
        result = map.get("love", 25);
        System.out.println(result);
    }
}
