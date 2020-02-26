package rearrangeString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String [] args) {
        Solution s = new Solution();
        String result = s.rearrangeString("aaadbbcc", 2);
        System.out.println(result);
    }
    public String rearrangeString(String s, int k) {



            char[] resultArr = new char[s.length()];
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i =0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) +1);
                } else {
                    map.put(c,1);
                }
            }

            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
            PriorityQueue<Map.Entry<Character, Integer>> wait = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());


            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                pq.add(entry);
            }

            int start = 0;
            int index = 0;
            while(!pq.isEmpty()) {

                Map.Entry<Character, Integer> entry = pq.remove();
                resultArr[index] = entry.getKey();
                index++;
                entry.setValue(entry.getValue()-1);
                if(entry.getValue() > 0) {
                    wait.add(entry);
                }


                if(wait.size() <k && wait.isEmpty() && !pq.isEmpty()) {
                    continue;
                }
                if(wait.isEmpty()) {break;}
                Map.Entry<Character, Integer> nextEntry = wait.remove();
                if(nextEntry.getValue() > 0) {
                    pq.add(nextEntry);
                }




            String result = new String(resultArr);
            if(result.length() > s.length()) {return "";}
            return result;

        }

        return "";
    }

    private boolean canBeRearranged(String s, int k) {
        int map[] = new int[26];

        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            map[c-'a']++;
        }

        Arrays.sort(map);

        int available_slot = (map[25] - 1 )*(k-1);
        int max = map[25] -1;
        int i =24;
        for(;i>=0; i--) {
            int used = Math.min(max, map[i]);
            available_slot = available_slot- used;
        }
        int cycle = 0;
        if(available_slot > 0) {
            cycle = available_slot + s.length();
        } else {
            cycle = s.length();
        }

        if(cycle > s.length()) {return false;}
        return true;
    }
}
