package maxSubArray;

public class Solution {

    public static void main(String [] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(arr);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        /*int sum = nums[0];
        int [] max = new int[nums.length];
        max[0] = sum;
        for(int i =1;i<nums.length; i++) {
            max[i] = Math.max(sum+ nums[i], nums[i]);
            sum = sum + max[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i:max) {
            maxSum = (i > maxSum) ? i : maxSum;
        }

        return maxSum;*/

        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
