package missing_number;


public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int arr[] = {9,6,4,2,3,5,7,0,8,1};
        int num = s.missingNumber(arr);
        System.out.println(num);
    }

    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
            System.out.println("xor= "+xor + " i= "+ i + " num[i]= "+ nums[i]);
        }

        return xor ^ i;
    }
}
