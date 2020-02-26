package city_skyline;

import java.util.HashMap;
import java.util.Map;

public class MaxIncreaseSkyline {
    public static void main(String []args) {
        int[][]inputGrid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        //int[][]inputGrid = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int maxSklylineIncrease = maxIncreaseKeepingSkyline(inputGrid);
        System.out.println(maxSklylineIncrease);

    }

    /*public static int maxIncreaseKeepingSkyline(int[][]inputGrid) {

        Map<Integer, Integer> maxValuesInRow = new HashMap<>();
        Map<Integer, Integer> maxValuesInCol = new HashMap<>();
        int maxSum = 0;
        int numOfRows = inputGrid.length;

        //traverse the array and find max values in each row
        for(int i =0;i<numOfRows;i++) {
            int max = 0; int row = 0; int col = 0;
            for (int j=0; j<inputGrid[i].length; j++) {
                if(inputGrid[i][j] > max) {
                    max = inputGrid[i][j];
                    row = i;
                    col = j;
                }
            }
            maxValuesInRow.put(row, col);
        }

        for(Map.Entry<Integer, Integer> entry: maxValuesInRow.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key = "+ key+ " value = "+ value);
        }
        int j = 1;
        //traverse the array and find the max values in each col
        for(int i =0; i<inputGrid[j-1].length; i++) {
            int max = 0; int row = 0; int col =0;
            for(j =0; j<inputGrid.length; j++) {
                if(inputGrid[j][i] > max) {
                    max = inputGrid[j][i];
                    row = j;
                    col = i;
                }
            }
            maxValuesInCol.put(col, row);
        }

        for(Map.Entry<Integer, Integer> entry: maxValuesInCol.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key = "+ key+ " value = "+ value);
        }

        for(int i = 0 ; i<inputGrid.length; i++) {
            if(maxValuesInRow.get(i) == null) {
                return 0;
            }
            int colWithMaxValue = maxValuesInRow.get(i);
            int maxValueInRow = inputGrid[i][colWithMaxValue];
            for(j = 0; j<inputGrid[i].length;j++) {
               int maxValue = maxValueInRow;
                if(maxValuesInCol.get(j) == null) {
                    return 0;
                }
               int rowWithMaxValue = maxValuesInCol.get(j);
               int maxValueInCol = inputGrid[rowWithMaxValue][j];

               if(maxValueInCol < maxValueInRow) {
                   maxValue = maxValueInCol;
               }
               System.out.println(maxValue);
               if(i != rowWithMaxValue && j != colWithMaxValue) {
                   maxSum = maxSum + maxValue - inputGrid[i][j];
               }
            }
        }

        return maxSum;
    }*/

    public  static int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }

        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];

        return ans;
    }
}
