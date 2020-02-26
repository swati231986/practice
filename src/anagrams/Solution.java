package anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int sLength = s.length();
        Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        List<Integer> result =  new ArrayList<Integer>();
        for(int index = 0; index<p.length(); index++) {
            if(charFrequency.get(p.charAt(index)) == null) {
                charFrequency.put(p.charAt(index),1);
            } else {
                int count = charFrequency.get(p.charAt(index));
                charFrequency.put(p.charAt(index),++count);
            }

        }
        int start = 0;
        while( start <= sLength-pLength ) {
            boolean noMatch= false;
            int i = start;
            Map<Character, Integer> charFrequencyCopy = new HashMap<Character, Integer>(charFrequency);
            for(; i< start+p.length(); i++) {
                if(charFrequencyCopy.get(s.charAt(i)) == null) {
                    noMatch = true;
                    break;
                }
                int count = charFrequencyCopy.get(s.charAt(i));
                charFrequencyCopy.put(s.charAt(i), --count);
            }
            if(noMatch) {
                start = i+1;
            } else {
                if( Collections.frequency(charFrequencyCopy.values(), 0) == charFrequencyCopy.size()) {
                    result.add(start);
                }
                start++;
            }

        }
        return result;
    }

    public static void main(String [] args) {
        List<Integer> result = findAnagrams("abab", "ab");
        for(Integer i:result) {
            System.out.println(i);
        }
    }
}
