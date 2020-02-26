package stringpermutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringAnagrams {
    public static void main(String args[]) {
        permutation("123");
       /* List<Integer> anagrams = findAnagrams("abab", "ab");
        for(Integer i:anagrams) {
            System.out.println(i);
        }*/
    }
    /* * A method exposed to client to calculate permutation of String in Java. */
    public static void permutation(String input){
        permutation("", input);
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String s1 = perm + word.charAt(i);
                String s2 = word.substring(0,i);
                String s3 = word.substring(i+1, word.length());
                permutation(perm + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        Map<Character, Integer> myMap = new HashMap();
        for(int i =0;i<p.length();i++) {
            Character c = p.charAt(i);
            if(myMap.get(c) != null) {
                int count = myMap.get(c);
                myMap.put(c, ++count);
            } else {
                myMap.put(c,1);
            }
        }


        int pLength  = p.length();
        for(int i =0;i< s.length() - pLength+1; i++) {
            Set<Character> mySet = new HashSet<>();
            boolean isAnagram = true;
            int count = i;
            int len = 0;
            Map <Character, Integer> helperMap = new HashMap<>();

            while(count<pLength+i) {
                Character charToCheck = s.charAt(count);
                if(myMap.get(charToCheck) == null) {
                    isAnagram = false;
                } else {
                    if(!mySet.contains(charToCheck)) {
                        mySet.add(charToCheck);
                        helperMap.put(charToCheck, 1);
                    } else {
                        if(helperMap.get(charToCheck) != null) {
                            int occurance = helperMap.get(charToCheck);
                            if(myMap.get(charToCheck) >occurance) {
                                len = len + occurance;
                                helperMap.put(charToCheck, ++occurance);
                            }
                        } else {
                            helperMap.put(charToCheck, 1);
                        }

                    }

                }
                count++;
            }

            if(isAnagram && mySet.size()+len == pLength) {
                result.add(i);
            }
        }

        return result;
    }



}
