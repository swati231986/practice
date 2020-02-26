package checkSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int nums[] = {0,0,1,0};
        boolean result = s.checkSubarraySum(nums,0);
        System.out.println(result);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++) {
            sum = sum + nums[i];

            if(k != 0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
