package rob;

public class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) {return 0;}

        return Math.max(rob(nums, 0, nums.length-2) , rob(nums, 1, nums.length-1));

    }

    private int rob(int[] nums, int start, int end) {
        int include = 0; int exclude = 0;

        for(int i=start; i<=end;i++) {
            int includeNew = nums[i] + exclude;
            exclude = Math.max(include, exclude);
            include = includeNew;
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //int arr[] = {2,1,1,2};
        //int arr[] = {1,3,1,3,100};
        int arr[] = {2,3,2};
        int result = s.rob(arr);
        System.out.println(result);
    }
}
