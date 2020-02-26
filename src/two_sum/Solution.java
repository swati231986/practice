package two_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String [] args) {
        //int[] arr = {3,2,4};
        int[] arr = {0,0};
        int [] result = twoSum(arr, 0);
        for(int num:result) {
            System.out.println(num);
        }
    }
    /*public static int[] twoSum(int[] nums, int target) {
        List <Integer>list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int i =0;
        int j = nums.length -1;
        int []result = new int[2];
        while(i<j) {
            if(target == (list.get(i) + list.get(j)) ) {

                result[0] = i;
                result[1] = j;
                return result;
            }
            if(target < list.get(i) + list.get(j)) {
                j--;
            }
            if(target > list.get(i) + list.get(j)) {
                i++;
            }
        }

        return result;
    }*/

    public static int[] twoSum(int []nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }
}
