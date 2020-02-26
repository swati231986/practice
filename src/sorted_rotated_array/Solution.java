package sorted_rotated_array;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int [] num = {2,3,4,5,6,7,8,9,1};
        int result = s.search(num,9);
        System.out.println(result);
    }
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int result = binarySearch(nums, 0, nums.length-1, target);
        return result;
    }

    private int binarySearch(int []nums, int start, int end, int target) {
        if(start > end) {return -1;}
        int mid = (start + end) / 2;
        if(nums[mid] == target) {return mid;}
        if(nums[start] == target) {return start;}
        if(nums[end] == target) {return end;}

        // find out if right part of array is contiguous or left
        if(mid+1 < nums.length && nums[mid+1] <= nums[end]) {
            if(target < nums[end] && target >= nums[mid+1]) {
                return binarySearch(nums, mid+1, end, target);
            } else {
                return binarySearch(nums, start, mid-1, target);
            }
        } else if(mid - 1 >= 0 && nums[mid - 1] >= nums[start]){
            if(target > nums[start] && target <= nums[mid-1]) {
                return binarySearch(nums, start, mid-1, target);
            } else {
                return binarySearch(nums, mid+1, end, target);
            }
        }
        return -1;
    }
}
