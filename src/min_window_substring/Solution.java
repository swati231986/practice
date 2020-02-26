package min_window_substring;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String [] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        //String s = "AA";
        //String t = "AA";

        //String s = "cabwefgewcwaefgcf";
        //String t = "cae";

        //String s = "babb";
        //String t = "baba";
        String minWindow = minWindow(s,t);
        System.out.println(minWindow);
    }

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                char c = s.charAt(right);
                int charFreq = map.get(s.charAt(right));

                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        int charFreqLeft = map.get(s.charAt(left));
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);
    }

    /*public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {return "";}

        Map<Character, Integer> charFrequency = new HashMap();

        for(int i =0; i < t.length(); i++) {
            char c = t.charAt(i);

            if(charFrequency.get(c) == null) {
                charFrequency.put(c, 1);
            } else{
                int count = charFrequency.get(c);
                charFrequency.put(c, ++count);
            }
        }

        Map<Character, Integer> charVisited = new HashMap<>();

        int start = -1;
        int end = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        String minString = "";
        String result = "";
        boolean found = false;
        while(end < s.length() && start < s.length() && start<=end && index <s.length()) {
            char startChar = s.charAt(index);

            if(charFrequency.get(startChar) != null && charVisited.get(startChar) == null) {
                charVisited.put(startChar,1);
                found = true;
                end = index;
            } else if (charVisited.get(startChar) != null && charFrequency.get(startChar) > 1 && charVisited.get(startChar)  < charFrequency.get(startChar)) {
                end = index;
                found = true;
                int count = charVisited.get(startChar);
                charVisited.put(startChar, ++count);
            }
            index++;


            minString = (found) ? minString + startChar : minString;
            start = (start == -1) ? end : start;
            if(t.length()== charVisited.values().stream().reduce(0,(a,b) -> a+b)) {
                int windowSize = end - start;
                min = Math.min(min, windowSize);
                start = start + 1;
                index = start;
                charVisited.clear();
                found = false;
                result = (result == "" ||( minString.length() < result.length())) ? minString :result;
                minString = "";
            }

        }

        return result;
    }*/
}
