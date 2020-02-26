package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    public static void main(String []args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();
        List<List<Integer>> result = s.threeSum(nums);
        result.forEach(e -> {
            System.out.println();
            e.forEach(l -> System.out.print(l + " "));
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length ==0) {return new ArrayList();}
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();

        for(int i = 0 ; i< nums.length-2;i++) {
            if(i>0 && nums[i] == nums[i-1]) {continue;}

            int sum = 0 - nums[i];
            int start = i+1;
            int end =nums.length-1;
            while(start < end) {
                List<Integer> combination = new ArrayList();
                if(nums[start] + nums[end] == sum) {
                    combination.add(nums[i]);
                    combination.add(nums[start]);
                    combination.add(nums[end]);
                    list.add(combination);
                    start++;
                    end--;
                } else if(nums[start] + nums[end] < sum) {
                    start++;
                } else {end--;}
            }

        }
        return list;
    }

    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        threeSum(result, new ArrayList(), nums, 0,0);
        return result;
    }

    private void threeSum(List<List<Integer>> result, List<Integer> list, int[] nums, int rem, int start) {
        if(rem == 0 && !list.isEmpty() && list.size() == 3) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start ; i<nums.length;i++ ) {
            if(nums[i] == nums[i-1])
            list.add(nums[i]);
            threeSum(result, list, nums, rem+nums[i], i+1);
            list.remove(list.size()-1);
        }
    }*/
}
