package rotated_sorted_array;

public class Solution {

    public static void main(String[] args) {
       // int [] array = {4,5,6,7,0,1,2};
        int [] array = {1,3};
        int result = search(array, 3);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) {return -1;}
        int length = nums.length;
        int count = target >= nums[0] ? 0 : (target <= nums[length-1]) ? length-1 : -1;
        if(count == -1) {return -1;}

        if(count == 0) {
            while(count <= length-2 && nums[count] < nums[count+1]) {
                if(nums[count] == target) {
                    return count;
                }
                count++;
            }
        } else if(count == length-1){
            while(count > 0 && nums[count-1] < nums[count]) {
                if(nums[count] == target) {
                    return count;
                }
                count--;
            }
        }
        if(target == nums[count]) {return count;}
        return -1;
    }
}
