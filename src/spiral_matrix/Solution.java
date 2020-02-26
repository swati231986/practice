package spiral_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        /*int [][] matrix = { { 1, 2, 3 },
                            { 4, 5, 6 },
                            { 7, 8, 9 }};*/

        /*int [][] matrix = {{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12}};*/

        //int [][] matrix = {{1,2,3,4,5,6,7,8,9,10}};
        int [][] matrix = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};

        List<Integer> spiral = spiralOrder(matrix);
        spiral.forEach(e -> System.out.println(e));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList();
        }
        if(matrix.length ==1) {
            return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());

        }

        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int row = 0;
        int col = 0;

        List<Integer> spiral = new ArrayList();

        while(row<=rows && col <= cols) {
            boolean wasExecuted  = false;
            for( int i = col; i<=cols &&  row <= rows ;i++) {
                int element = matrix[row][i];
                spiral.add(element);
                wasExecuted = true;

            }
            row = wasExecuted ? row+1: row;
            wasExecuted = false;
            for(int i = row; i <= rows && col <= cols; i++) {
                int element = matrix[i][cols];
                spiral.add(element);
                wasExecuted = true;
            }
            cols = wasExecuted ? cols-1 : cols;
            wasExecuted = false;
            for(int i = cols; i>=col && row <= rows; i--) {
                int element = matrix[rows][i];
                spiral.add(element);
                wasExecuted = true;
            }

            rows = wasExecuted ? rows-1 : rows;
            wasExecuted = false;
            for(int i = rows; i>=row &&  col <= cols ; i--) {
                int element = matrix[i][col];
                spiral.add(element);
                wasExecuted = true;
            }
            col = wasExecuted ? col+1 : col;
        }

        return spiral;



    }
}
