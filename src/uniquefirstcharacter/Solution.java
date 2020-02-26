package uniquefirstcharacter;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {


    public static void main(String [] args) {
        String s = "z";
        System.out.println(firstUniqChar(s));
    }

    /*public static int firstUniqChar(String s) {
        Map<Character, Integer> uniqueCharIndexMap = new HashMap();
        Set<Character> nonUniqueChar =  new HashSet<>();
        for(int i =0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(uniqueCharIndexMap.get(c) == null && !nonUniqueChar.contains(c)) {
                uniqueCharIndexMap.put(c, i);
            } else {
                uniqueCharIndexMap.remove(c);
                nonUniqueChar.add(c);
            }
        }
        if(uniqueCharIndexMap.isEmpty()) {return -1;}
        Map.Entry<Character, Integer> min = Collections.min(uniqueCharIndexMap.entrySet(), Comparator.comparing(Map.Entry::getValue));

        return min.getValue();


    }*/

    public static int firstUniqChar(String s) {
        if(s == null) {return -1;}
        int min = Integer.MAX_VALUE;
        for(char c = 'a'; c<='z';c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c) && index < min) {
                min = index;
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        return min;
    }
}
