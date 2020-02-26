package permutation_string;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        //permutations("123");
        int [] nums = {1,1,2,3};
        List<List<Integer>>permutations = permutationsWithDuplicate(nums);
        permutations.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element));
        });
    }

    public static void permutations(String  word) {
        permutations(word, word);
    }

    public static  List<List<Integer>> permutationsWithDuplicate(int[]  word) {
        boolean [] used = new boolean[word.length];
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(word);
        permuteWithDuplicate(word, new ArrayList<>(),permutations, used);
        return permutations;
    }

    private static void permutations(String perm, String  word) {
        if(word.isEmpty()) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String s= perm + word.charAt(i);
                String sub1 = word.substring(0,i);
                String sub2 = word.substring(i+1, word.length());
                permutations(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }

        }

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>() ;
        permute(nums, permutations,new ArrayList<>());
        return permutations;
    }

    private static void permute(int[] nums, List<List<Integer>> permutations, List<Integer> perm) {
        if(nums.length == perm.size()) {

            permutations.add(perm);

        } else {
            for(int i  = 0; i<nums.length ; i++) {
                int x = nums[i];
                if(perm.contains(nums[i])) {continue;}
                perm.add(nums[i]);
                permute(nums, permutations, perm);
                perm.remove(perm.size()-1);
            }
        }


    }

    private static void permuteWithDuplicate(int[] nums, List<Integer> perms, List<List<Integer>> permutations, boolean []used) {

        if(perms.size() == nums.length) {
            permutations.add(new ArrayList(perms));
        } else {
            for( int i =0; i<nums.length; i++) {
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }
                perms.add(nums[i]);
                used[i] = true;
                permuteWithDuplicate(nums, perms, permutations, used);
                perms.remove(perms.size()-1);
                used[i] = false;
            }
        }

    }



}
