package find_duplicates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        Solution s = new Solution();
        List<Integer> duplicates = s.findDuplicates(nums);
        for(int num: duplicates) {System.out.println(num);}
    }

    public List<Integer> findDuplicates(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList();
        }

        List<Integer> duplicates = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                x = 0-x;
            }
            if (nums[x - 1] < 0) {
                duplicates.add(x);
            } else {
                nums[x - 1] = 0 - nums[x - 1];
            }
        }

        return duplicates;
    }
}
