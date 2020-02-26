package findDiagonalOrder;

import java.util.Stack;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int [][] matirx = { {1,2,3},
                            {4,5,6},
                            {7,8,9}};
        int[] result = s.findDiagonalOrder(matirx);
        Stream.of(result).forEach(e -> System.out.println(e));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            int arr[] = {};
            return arr;
        }
        int rows = matrix.length - 1;
        int columns = matrix[0].length - 1;

        int[] result = new int[matrix.length * matrix[0].length];
        int row = 0;
        int col = 0;
        for (int i = 0; i < result.length; i++) {

            result[i] = matrix[row][col];


            if ((row + col) % 2 == 0) {
                if (col == columns) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
        /*public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0){
            int arr[] = {};
            return arr;
        }
        int[]result = new int[matrix.length * matrix[0].length];
        int count = 0;
        boolean upDown = false;
        for(int i =0; i<matrix.length;i++) {
            int startCol = 0;
            if(i>0) {
                startCol = matrix[i].length-1;
            }

            for(int j = startCol; j<matrix[i].length; j++) {
                int x = i;
                int y = j;
                if(upDown) {
                    while( y >= 0 && x < matrix.length) {
                        result[count++] = matrix[x][y];
                        x++; y--;
                    }
                    upDown = false;
                } else {
                    Stack<Integer> stack = new Stack();

                    while( y >= 0 && x < matrix.length) {
                        stack.push(matrix[x][y]);
                        x++; y--;
                    }
                    while(!stack.isEmpty()) {
                        result[count++] = stack.pop();
                    }
                    upDown = true;
                }

            }
        }

        return result;
    }*/
}
