package count_negatives;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]grid = { {4,  3, 2,-1},
                        {3,  2, 1,-1},
                        {1,  1,-1,-2},
                        {-1,-1,-2,-3}};
        int result = s.countNegatives(grid);
        System.out.println(result);

    }
    public int countNegatives(int[][] grid) {


        if(grid.length == 0) {return -1;}
        int count = 0; int maxCol = grid[0].length-1;
        int minCol = grid[0].length;
        for(int i =0; i<grid.length; i++) {

            int index = binarySearch(grid, i, 0, maxCol);

            if(index < 0 || minCol < index) {
                continue;
            }
            maxCol = index -1;
            int currCount = (grid.length - i) * (minCol- index);
            count = count + currCount;
            minCol = Math.min(minCol, index);
        }
        return count;
    }

    private int binarySearch(int[] [] grid, int row, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end)/2;

        if(grid[row][mid] < 0) {
            if((mid-1 >= 0 && grid[row][mid-1] >=0) || mid == 0) {
                return mid;
            }
            return binarySearch(grid, row, start, mid-1);
        } else {
            return binarySearch(grid, row, mid+1, end);
        }
    }
}
