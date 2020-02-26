package generate_combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String []args) {
        String [] arr = {"call", "get", "set"};
        Solution s = new Solution();
        List<List<String>> result = s.generateCombinations(arr,1);
        result.forEach(e-> {
            System.out.println();
            e.forEach(element -> System.out.print(" "+ element));
        });
        result = s.generateCombinations(arr,2);
        result.forEach(e-> {
            System.out.println();
            e.forEach(element -> System.out.print(" "+ element));
        });

        result = s.generateCombinations(arr,3);
        result.forEach(e-> {
            System.out.println();
            e.forEach(element -> System.out.print(" "+ element));
        });
    }

    public List<List<String>> generateCombinations(String []arr, int k) {


        List<List<String>> result = new ArrayList<>();
        boolean [] used = new boolean[arr.length];
        generateTwoStringCombination(arr, result, new ArrayList<>(), k, used);

        return result;

    }

    private void generateTwoStringCombination(String []arr, List<List<String>> result, List<String> list, int k, boolean[]used) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
        }
            for(int i = 0; i<arr.length; i++) {
                if(used[i] ) {continue;}
                list.add( arr[i]);
                used[i] = true;
                generateTwoStringCombination(arr, result, list, k, used);
                list.remove( list.size()-1);
                used[i] = false;

            }



    }
}
