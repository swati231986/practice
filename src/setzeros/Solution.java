package setzeros;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //nt[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        /*int[][] matrix =   {{0,1,2,0},
                            {3,4,5,2},
                            {1,3,1,5}};*/

        int[][] matrix =   {{1,1,1},
                            {0,1,2}};
        s.setZeroes(matrix);

        Arrays.stream(matrix).forEach(e -> {
            System.out.println();
            Arrays.stream(e).forEach( element -> System.out.println(element));
        });
    }

    public void setZeroes(int[][] matrix) {

        boolean col0 = false;

        for(int i =0; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                col0 = true;
            }
            for(int j = 0; j<matrix[i].length; j++) {

                if(matrix[i][j] ==0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;

                }
            }
        }
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                makeZero(matrix, true, i);
            }
        }

        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                makeZero(matrix, false, j);
            }
        }

        if(col0) {
            makeZero(matrix, false, 0);
        }
    }

    /*public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet();
        Set<Integer> cols = new HashSet();

        for(int i =0; i<matrix.length; i++) {
            for(int j =0; j<matrix[i].length; j++) {

                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }


        for(Integer row:rows) {
            makeZero(matrix, true, row);
        }
        for(Integer col:cols) {
            makeZero(matrix, false, col);
        }


    }*/

    private void makeZero(int[][] matrix, boolean isRow, int i) {
        if(isRow) {
            for(int j = 1; j<matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        } else {
            for(int j = 1; j<matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
