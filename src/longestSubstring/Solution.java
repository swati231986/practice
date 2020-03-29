package longestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.longestSubstring("ababbc", 2);
        System.out.println(result);
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }

   /* public int longestSubstring(String s, int k) {
        if(s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> firstIndexMap = new HashMap();
        Map<Character, Integer> freq = new HashMap();

        int range = 0; int maxRange = 0;
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!firstIndexMap.containsKey(c)) {
                firstIndexMap.put(c, i);
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) +1);
                if(freq.get(c) >= k) {
                    int start = firstIndexMap.get(c);
                    int end = i;
                    boolean kSumFound = true;
                    while(end>= start) {
                        if(freq.get(s.charAt(end)) < k) {
                            kSumFound = false;
                            break;
                        }

                        end--;
                    }
                    if(kSumFound) {
                        range = i - end ;
                        maxRange = Math.max(range, maxRange);
                    }
                }

            }

        }

        return maxRange;

    }*/
}
