package sentence_similarity_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        /*String[] words1 = {"an","extraordinary","meal"};

        String[] words2 = {"one","good","dinner"};

        List<List<String>> pairs =  new ArrayList<>();
        pairs.add(Arrays.asList(new String[]{"great","good"}));
        pairs.add(Arrays.asList(new String[]{"extraordinary","good"}));
        pairs.add(Arrays.asList(new String[]{"well","good"}));
        pairs.add(Arrays.asList(new String[]{"wonderful","good"}));
        pairs.add(Arrays.asList(new String[]{"excellent","good"}));
        pairs.add(Arrays.asList(new String[]{"fine","good"}));
        pairs.add(Arrays.asList(new String[]{"nice","good"}));
        pairs.add(Arrays.asList(new String[]{"any","one"}));
        pairs.add(Arrays.asList(new String[]{"some","one"}));

        pairs.add(Arrays.asList(new String[]{"unique","one"}));
        pairs.add(Arrays.asList(new String[]{"the","one"}));
        pairs.add(Arrays.asList(new String[]{"an","one"}));
        pairs.add(Arrays.asList(new String[]{"single","one"}));
        pairs.add(Arrays.asList(new String[]{"a","one"}));
        pairs.add(Arrays.asList(new String[]{"truck","car"}));
        pairs.add(Arrays.asList(new String[]{"wagon","car"}));
        pairs.add(Arrays.asList(new String[]{"automobile","car"}));
        pairs.add(Arrays.asList(new String[]{"auto","car"}));
        pairs.add(Arrays.asList(new String[]{"vehicle","car"}));
        pairs.add(Arrays.asList(new String[]{"entertain","have"}));
        pairs.add(Arrays.asList(new String[]{"drink","have"}));
        pairs.add(Arrays.asList(new String[]{"eat","have"}));
        pairs.add(Arrays.asList(new String[]{"take","have"}));
        pairs.add(Arrays.asList(new String[]{"fruits","meal"}));
        pairs.add(Arrays.asList(new String[]{"brunch","meal"}));
        pairs.add(Arrays.asList(new String[]{"breakfast","meal"}));
        pairs.add(Arrays.asList(new String[]{"food","meal"}));
        pairs.add(Arrays.asList(new String[]{"dinner","meal"}));
        pairs.add(Arrays.asList(new String[]{"super","meal"}));
        pairs.add(Arrays.asList(new String[]{"lunch","meal"}));
        pairs.add(Arrays.asList(new String[]{"possess","own"}));
        pairs.add(Arrays.asList(new String[]{"keep","own"}));
        pairs.add(Arrays.asList(new String[]{"have","own"}));
        pairs.add(Arrays.asList(new String[]{"extremely","very"}));
        pairs.add(Arrays.asList(new String[]{"actually","very"}));
        pairs.add(Arrays.asList(new String[]{"really","very"}));
        pairs.add(Arrays.asList(new String[]{"super","very"}));*/


        String[] words1 = {"great","acting","skills"};

        String[] words2 = {"fine","painting","talent"};
        List<List<String>> pairs =  new ArrayList<>();
        pairs.add(Arrays.asList(new String[]{"great","fine"}));
        pairs.add(Arrays.asList(new String[]{"drama","acting"}));
        pairs.add(Arrays.asList(new String[]{"skills","talent"}));


        Solution s = new Solution();
        boolean result = s.areSentencesSimilarTwo(words1, words2, pairs);
        System.out.println(result);
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if(words1.length == 0 && words2.length == 0) {
            return true;
        }
        if(words1.length == 0) {
            return false;
        }
        if(words2.length == 0) {
            return false;
        }
        if(words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap();
        for(List<String> pair:pairs) {
            if(!map.containsKey(pair.get(0))){
                map.put(pair.get(0), new HashSet<>());
            }
            if(!map.containsKey(pair.get(1))){
                map.put(pair.get(1), new HashSet<>());
            }

            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }


        for(int i =0; i<words1.length && i<words2.length; i++) {
            if(!dfs(words1[i], words2[i], map, new HashSet<>()) ) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(String node, String target, Map<String,Set<String>> map, Set<String> visited) {
        if(node.equals(target)) {
            return true;
        }
        if(map.containsKey(node) && map.get(node).contains(target)) {
            return true;
        }
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for(String child:map.get(node)) {
            if(dfs(child, target, map, visited)) {
                return true;
            }
        }
        return false;
    }

}
