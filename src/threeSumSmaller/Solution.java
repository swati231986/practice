package threeSumSmaller;

import java.util.Arrays;

public class Solution {

    public static void main(String [] arg){
        Solution s = new Solution();
        int [] nums = {3,1,0,-2};
        int count = s.threeSumSmaller(nums,4);
        System.out.println(count);
    }

    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length == 0) {return 0;}
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i<nums.length-2; i++) {
            int x = target - nums[i];
            int start = i+1;
            int end = nums.length-1;

            while(start<end) {
                if(nums[start] + nums[end] == x) {
                    end--;
                } else if(nums[start] + nums[end] < x) {
                    count = count + end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }

        return count;
    }
}
