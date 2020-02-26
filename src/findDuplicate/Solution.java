package findDuplicate;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int [] nums = {3,1,3,4,2};
        int num = s.findDuplicate(nums);
        System.out.println(num);
    }

    public int findDuplicate(int[] nums) {

        int len = nums.length;
        if(len == 0) {return -1;}
        /*int expectedSum = (len-1) * len /2;
        int sum = 0;
        for(int num: nums){sum = sum+num;}
        return sum;*/

        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }


        slow = 0;

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
