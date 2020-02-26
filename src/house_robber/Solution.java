package house_robber;

public class Solution {
    public static void main(String [] args) {
        int [] nums = {2,7,9,3,1};
        int result = rob(nums);
        System.out.println(result);
    }
    public static int rob(int [] nums) {

        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int []max = new int[nums.length];
        max[0] = nums[0];
        int maxSum = Math.max(nums[0], nums[1]);
        max[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++) {
            if(i-3 >=0) {
               max[i] = Math.max(max[i-2], max[i-3]) + nums[i];
            }
            max[i] = (i-3 >=0) ? Math.max(max[i-2], max[i-3]) + nums[i] : max[i-2] + nums[i];
            maxSum = Math.max(maxSum, max[i]);
        }
        return maxSum;
    }
}
