package palindromic_substrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int count = 0;
    public static void main(String [] args) {
        int count = countSubstrings("aaabcb");
        System.out.println(count);

        count = countSubstrings("aaa");
        System.out.println(count);

        count = countSubstrings("abc");
        System.out.println(count);

        count = countSubstrings("aa");
        System.out.println(count);

        count = countSubstrings("a");
        System.out.println(count);

        count = countSubstrings("ababjreghtth");
        System.out.println(count);

    }

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private static void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
    /*public static int countSubstrings(String s) {
        if(s.length() == 1) {return 1;}
        if(s == null) {return 0;}
        int count = 0;
        int start = 0;
        int end = 1;

        while(start >= 0 && end < s.length()) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(startChar == endChar) {
                count++;
                if(start != 0 && end + 1 < s.length() && s.charAt(start-1) == s.charAt(end + 1)) {
                    start--;
                    end++;
                    continue;
                }
            } else {
                if(end+1 < s.length() && startChar == s.charAt(end+1) ) {
                    end++;
                    continue;
                }
            }
            start++;
            end++;
        }

        Set<Character> characters = new HashSet<>();
        for(int i =0; i<s.length() ; i++) {
            Character c = s.charAt(i);
            if(!characters.contains(c)) {
                count++;
                characters.add(c);
            }
        }

        return count;
    }*/
}
