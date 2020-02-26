package longest_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {



    public static void main(String [] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aaa"));
        System.out.println(lengthOfLongestSubstring("cdd"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdrht"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)) {return 0;}

        int start = 0;
        int end = 0;
        Map<Character, Integer> charUsedIndex = new HashMap();
        int max = Integer.MIN_VALUE;
        int length = 0;

        while(start < s.length() && end < s.length() ){
            Character endChar = s.charAt(end);
            Character startChar = s.charAt(start);
            if(charUsedIndex.containsKey(endChar)) {
                start = Math.max(start, charUsedIndex.get(endChar) + 1);
            }
            charUsedIndex.put(endChar, end);
            max = Math.max(max, (end-start) + 1);
            end++;

        }
        max = Math.max(max, length);
        return max;
    }
}
