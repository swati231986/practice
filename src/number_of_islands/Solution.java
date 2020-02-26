package number_of_islands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        //char [][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char [][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        /*char [][] grid = {  {'1','1','1','1','1','1','1'},
                            {'0','0','0','0','0','0','1'},
                            {'1','1','1','1','1','0','1'},
                            {'1','0','0','0','1','0','1'},
                            {'1','0','1','0','1','0','1'},
                            {'1','0','1','1','1','0','1'},
                            {'1','1','1','1','1','1','1'}};*/
        char [][] grid = {  {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}};
        Solution s = new Solution();
        int num = s.numIslands(grid);
        System.out.println(num);
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0) {return 0;}

        int count = 0;
        for(int i =0; i<grid.length; i++) {
            for(int j =0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    findIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void findIsland(char[][]grid, int i, int j) {
        if(i < 0 || i>= grid.length || j <0 || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }

        if(i >=0 && i <grid.length && j-1 >= 0 && j-1 < grid[0].length) {
            findIsland(grid, i, j-1);
        }
        if(i >=0 && i <grid.length && j+1 >= 0 && j+1 < grid[0].length) {
            findIsland(grid, i, j+1);
        }
        if(i-1 >=0 && i-1 <grid.length && j >= 0 && j < grid[0].length) {
            findIsland(grid, i-1, j);
        }
        if(i+1 >=0 && i+1 <grid.length && j >= 0 && j < grid[0].length) {
            findIsland(grid, i+1, j);
        }
    }
    /*public int numIslands(char[][] grid) {

        if(grid.length == 0) {return 0;}
        int rows = grid.length;
        int cols = grid[0].length;

        int [][] gridInt = new int[grid.length][grid[0].length];
        List<Integer> ids = new ArrayList();

        for(int i =0; i<grid.length;i++) {
            for(int j =0; j<grid[i].length; j++) {
                gridInt[i][j] = Character.getNumericValue(grid[i][j]);
            }
        }

        int[] prev = new int[cols];

        for(int i =0; i<rows; i++) {
            if(i == 0) {
                prev = populateFirstRow(gridInt[0], ids);
            } else {
                prev = populateRow(gridInt[i], prev, ids);
            }
        }

        Set<Integer> set = new HashSet();

        int count = 0;
        for(Integer id: ids) {
            if(!set.contains(id)) {
                count++;
                set.add(id);
            }
        }
        return count;

    }

    private int[] populateRow(int [] arr, int [] prev, List<Integer> ids) {

        int [] result = new int[arr.length];

        for(int col = 0; col< arr.length; col++) {
            //check only if there is a 1
            if(arr[col] == 0) {continue;}

            //if it is the first col
            if(col == 0) {
                //if prev array element is 0
                if(prev[col] == 0) {
                    if(ids.isEmpty()) {
                        result[col] = 1;
                        ids.add(1);
                    } else {
                        result[col] = ids.size()+1;
                        ids.add(ids.size()+1);
                    }
                } else {
                    result[col] = prev[col];
                }
            } else {
                //for all other columns

                //if prev array element is 0 and element on the left is 0
                if(prev[col] == 0 && arr[col-1] == 0) {
                    //add a new element
                    if(ids.isEmpty()) {
                        result[col] = 1;
                        ids.add(1);
                    } else {
                        result[col] = ids.size()+1;
                        ids.add(ids.size()+1);
                    }
                } else if(prev[col] == 0 && arr[col-1] != 0) {
                    result[col] = result[col-1];
                } else if(prev[col] != 0 && arr[col-1] ==0) {
                    result[col] = prev[col];
                } else if(prev[col] != 0 && arr[col-1] != 0) {
                    if(prev[col] == result[col-1]) {
                        result[col] = prev[col];
                    } else {
                        int min = Math.min(result[col-1], prev[col]);
                        int max = Math.max(result[col-1], prev[col]);
                        ids.remove(max-1);
                        ids.add(max-1, min);
                        result[col] = min;
                    }
                }
            }
        }

        return result;
    }

    private int[] populateFirstRow(int [] arr, List<Integer> ids) {
        int [] result = new int[arr.length];

        for(int i =0; i<arr.length; i++) {
            if(arr[i] == 0) {continue;}
            if(i == 0) {
                result[0] = 1;
                ids.add(1);
            } else if(i > 0 && arr[i-1] == 1)  {
                result[i] = result[i-1];
            } else if(i > 0 && arr[i-1] == 0) {
                if(ids.isEmpty()) {
                    result[i] = 1;
                    ids.add(1);
                } else {
                    result[i] = ids.size()+1;
                    ids.add(ids.size()+1);
                }
            }
        }
        return result;
    }*/


}
