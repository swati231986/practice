package climbStairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(4));
    }

    Map<Integer, Integer> memo = new HashMap();

    /*public int climbStairs(int n) {
        this.memo.put(0, 0);
        this.memo.put(1, 1);
        this.memo.put(2, 2);
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = climbStairs(n-1) + climbStairs(n-2);
        this.memo.put(n, result);
        return result;

    }*/

    public int climbStairs(int n) {

        int matrix [][] = {{1,1}, {1,0}};
        int ret [][] = {{1,1}, {1,0}};

        for(int i =1; i<n; i++) {
            ret = multiply(ret, matrix);
        }
        return ret[0][0];
    }

    public int[][] multiply(int [][] matrix1, int [][] matrix2) {
        if(matrix1[0].length != matrix2.length) {
            return new int[0][0];
        }
        int result [][] = new int[matrix1.length][matrix2[0].length];

        for(int i =0; i<matrix1.length; i++) {

            for(int j = 0; j< matrix2[0].length; j++) {
                int sum = 0;
               for(int k = 0; k <matrix2.length; k++) {
                   sum = sum + matrix1[i][k] * matrix2[k][j];
               }
                result[i][j] = sum;
            }

        }
        return result;
    }

}
