package isAlienSorted;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

       // String[] words =  {"word","world","row"};
       // String order = "worldabcefghijkmnpqstuvxyz";
        boolean result = s.isAlienSorted(words, order);
        System.out.println(result);
    }
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 0 || order == null || order.length() == 0) {return false;}

        Map<Character, Integer> orderMap = new HashMap();

        for(int i = 0; i<order.length(); i++) {
            char c = order.charAt(i);
            orderMap.put(c, i);
        }

        int maxLen = 0;
        for(String word:words) {
            maxLen = Math.max(maxLen, word.length());
        }
        int index = 0;
        boolean areSame = true;

        while(index<maxLen && areSame) {
            areSame = false;
            for(int i = 0; i<words.length;i++) {
                if(i>0) {
                    if(index < words[i].length() && index < words[i-1].length()) {

                        char current = words[i].charAt(index);
                        char prev = words[i-1].charAt(index);
                        if(orderMap.get(current) < orderMap.get(prev) ) {
                            return false;
                        } else if( orderMap.get(current) == orderMap.get(prev)) {
                            areSame = true;
                        }
                    }
                }
            }
            index++;
        }


        return true;

    }
}
