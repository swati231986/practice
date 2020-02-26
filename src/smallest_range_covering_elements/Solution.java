package smallest_range_covering_elements;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]nums= {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        int result[] = s.smallestRange(nums);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }
    public int[] smallestRange(int[][] nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = i; k < nums.length; k++) {
                    for (int l = (k == i ? j : 0); l < nums[k].length; l++) {
                        int min = Math.min(nums[i][j], nums[k][l]);
                        int max = Math.max(nums[i][j], nums[k][l]);
                        int n, m;
                        for (m = 0; m < nums.length; m++) {
                            for (n = 0; n < nums[m].length; n++) {
                                if (nums[m][n] >= min && nums[m][n] <= max)
                                    break;
                            }
                            if (n == nums[m].length)
                                break;
                        }
                        if (m == nums.length) {
                            if (miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                miny = max;
                                minx = min;
                            }
                        }
                    }
                }
            }
        }
        return new int[] {minx, miny};
    }
}
