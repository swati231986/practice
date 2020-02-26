package subarraySum;

public class Solution  {

    public static void main(String [] args) {
        Solution s = new Solution();
        int arr[] = {1,2,3};
        int sum = s.subarraySum(arr, 3);
        System.out.println(sum);
    }

    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) {return 0;}
        if(nums.length == 1) {
            if(nums[0] == k) {return 1;}
            return 0;
        }
        int start = 0; int end = 1;
        int count = 0;
        while(start<nums.length && end< nums.length && start<=end ) {
            if(start == end) {
               count = nums[start] == k ? ++count : count;
               start++;
               end++;
            } else if(nums[start] + nums[end] == k) {
                count++;
                start++;
                end++;
            } else if(nums[start] + nums[end] < k) {
                end++;
            } else {
                start++;
            }
        }

        return count;
    }
}
