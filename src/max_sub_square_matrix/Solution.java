package max_sub_square_matrix;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        /*char[][] matrix = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};*/

        char[][] matrix = {{'0','1'},
                        {'0','1'}};

        int max = s.maximalSquare(matrix);
        System.out.println(max);
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {return 0;}
        int max = Integer.MIN_VALUE;
        int x = 0; int y = 0;
        int[] [] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;

            max = Math.max(dp[0][i], max);
            x = max == dp[0][i] ? 0 : x;
            y = max == dp[0][i] ? i : y;
        }
        for(int i = 0; i<matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;

            max = Math.max(dp[i][0], max);
            x = max == dp[i][0] ? i : x;
            y = max == dp[i][0] ? 0 : y;
        }

        for(int i =1;i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    int min = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                } else{
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
                x = max == dp[i][j] ? i : x;
                y = max == dp[i][j] ? j : y;

            }
        }
        int sum = 0;
        if(matrix.length == 2 && matrix[0].length == 2) {
            return matrix[x][y] == '1' ? 1 : 0;

        }

        if(matrix[x][y] == '1') {
            sum++;
        }
        if(y-1< matrix.length && y-1>=0 && matrix[x][y-1] == '1') {
            sum++;
        }
        if(y-1< matrix.length && y-1>=0 && x-1< matrix.length && x-1>=0 && matrix[x-1][y-1] == '1') {
            sum++;
        }
        if(x-1< matrix.length && x-1>=0 && matrix[x-1][y] == '1') {
            sum++;
        }
        return sum;

    }
}
