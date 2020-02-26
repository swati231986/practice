package lengthOfLongestSubstringKDistinct;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String [] args) {
        Solution s =  new Solution();
        int length = s.lengthOfLongestSubstringKDistinct("eceba",2);
        System.out.println(length);
    }

    /*public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap();
        int len = 0;
        int maxLen = 1;


        int end = 0;

        while( end<s.length()) {
            char c = s.charAt(end);

            map.put(c, end);
            end++;

            if(map.size() > k) {
                int minIndex = Collections.min(map.values());
                len = end - minIndex;
                maxLen = Math.max(len, maxLen);

                map.remove(s.charAt(minIndex));

            }
        }

        return maxLen;
    }*/

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }
}
