package shortest_word_distance;

import com.google.common.collect.ImmutableSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordDistance {
    private String [] words;
    Map<String, List<Integer>>  wordIndexes = new HashMap<>();
    public WordDistance(String[] words) {
        this.words = words;
        for(int i =0; i<words.length ; i++) {
            if(wordIndexes.get(words[i]) == null ) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                wordIndexes.put(words[i], list);
            } else {
                wordIndexes.get(words[i]).add(i);
            }
        }

    }


    public int shortest(String word1, String word2) {

        List<Integer> list1 = wordIndexes.get(word1);
        List<Integer> list2 = wordIndexes.get(word2);
        int minDistance = Integer.MAX_VALUE;

        for(int i =0, j=0; i<list1.size() && j <list2.size();  ) {
            if(list1.get(i) < list2.get(j)) {
                minDistance = Math.min(minDistance, list2.get(j) - list1.get(i));
                i++;
            } else {
                minDistance = Math.min(minDistance, list1.get(i) - list2.get(j));
                j++;
            }
        }

        return minDistance;

    }
}
