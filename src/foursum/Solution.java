package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();

        //int [] num = {1,0,-1,0,-2,2};
        //int [] num = {-3,-2,-1,0,0,1,2,3};
        int [] num = {-1,0,-5,-2,-2,-4,0,1,-2};

        //List<List<Integer>> list = s.fourSum(num, 0);
        List<List<Integer>> list = s.fourSum(num, -9);
        list.forEach(e -> {
            System.out.println();
            e.forEach(elements -> System.out.print(elements + " "));
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length == 0) {return new ArrayList();}

        Arrays.sort(nums);
        List<List<Integer>> allSums = new ArrayList();

        for(int i = 0; i< nums.length -3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {continue;}

            int num1 = nums[i];

            for(int j = i+1; j< nums.length-2 ; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) {continue;}
                int num2 = nums[j];
                int sum = target - (num1 + num2);
                int start  = j+1;
                int end  = nums.length -1;
                List<Integer> comb = new ArrayList();

                while(start<end) {
                    if(nums[start] + nums[end] == sum) {
                        comb = new ArrayList();
                        comb.add(num1);  comb.add(num2);  comb.add(nums[start]);  comb.add(nums[end]);
                        allSums.add(comb);
                        start++;
                        end--;
                        while(start<end && nums[start] == nums[start-1]) {start++;}
                        while(start<end && nums[end] == nums[end+1]) {end--;}
                    } else if(nums[start] + nums[end] <sum) {
                        start++;
                    } else {
                        end--;
                    }
                }



            }
        }

        return allSums;
    }
}
