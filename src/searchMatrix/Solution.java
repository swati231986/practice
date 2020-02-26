package searchMatrix;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] matrix = {{6,7},{9,10}};
        int[][] matrix = {{-5}};
        boolean result = s.searchMatrix(matrix, -10);
        System.out.println(result);
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {return false;}

        int row = matrix.length - 1;
        int col = 0;

        while(row >= 0 && col < matrix[row].length) {
            int n = matrix[row][col];
            if(target > matrix[row][col]) {
                col++;
            } else if(target < matrix[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
