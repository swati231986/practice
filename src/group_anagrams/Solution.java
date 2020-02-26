package group_anagrams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String []args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String [] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<List<String>> anagrams = groupAnagrams(strs);
        anagrams.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element + " "));
        });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0) {return new ArrayList<>();}

        Map<String, List<String>> stringListMap = new HashMap<>();

        for(String str: strs) {
            String str_copy = str;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedChars = String.valueOf(chars);
            if(stringListMap.get(sortedChars) != null) {
                stringListMap.get(sortedChars).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str_copy);
                stringListMap.put(sortedChars, anagrams);
            }
        }

        return new ArrayList<>(stringListMap.values());
    }
}
