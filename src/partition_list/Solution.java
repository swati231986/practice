package partition_list;

public class Solution {
    public static void main(String [] args) {
        int []nums = {4, 3, 2, 5, 1};
        //int []nums = {2,2,2,2,3,4,5};

        boolean result = canPartitionKSubsets(nums, 3);
        System.out.println(result);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)sum += num;
        if(k <= 0 || sum%k != 0)return false;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, k, 0, visited, 0, sum/k);
    }

    private static boolean canPartition(int [] nums, int k, int startIndex, boolean[]visited, int currentSum ,int targetSum) {
        if(k == 1) {
            return true;
        }
        if(currentSum == targetSum) {
            return canPartition(nums, k-1, 0, visited, 0, targetSum);
        }
        for(int i = startIndex ; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int currentnum = nums[i];
                int sum = currentSum + currentnum;
                if (canPartition(nums, k, i + 1, visited, currentSum + nums[i], targetSum)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

}
