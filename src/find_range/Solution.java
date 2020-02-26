package find_range;

import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        int [] nums = {5,7,7,8,8,8,8,8, 121,132, 200, 201};
        int [] result = searchRange(nums, 8);

        Stream.of(result).forEach(e -> System.out.println(e));
    }


    public static int[] searchRange(int[] A, int target) {
        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

    /*public int[] searchRange(int[] nums, int target) {
        int [] result = {-1,-1};
        if(nums.length == 0) {return result;}
        int min = 0;
        int max = nums.length-1;
        boolean foundMin = false;
        boolean foundMax = false;

        while(min < nums.length && max >= 0 && (!foundMin || !foundMax) ) {
            if(!foundMin) {
                if(nums[min] > target) {
                    return result;
                }
                if(nums[min] == target ) {
                    result[0] = min;
                    foundMin = true;
                } else {
                    min++;
                }
            }

            if(!foundMax) {
                if(nums[max] < target) {
                    return result;
                }
                if(nums[max] == target) {
                    result[1] = max;
                    foundMax = true;
                } else {
                    max--;
                }
            }

        }

        return result;

    }*/
}
