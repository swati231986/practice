package numSubarrayProductLessThanK;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10,5,2,6};
        int result = s.numSubarrayProductLessThanK(nums, 100);
        System.out.println(result);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
