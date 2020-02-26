package numDistinctIslands;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        /*int [][] grid = {   {1,1,0,0,0},
                            {1,1,0,0,0},
                            {0,0,0,1,1},
                            {0,0,0,1,1}};*/
        int [][]grid = {{1,1,0},
                        {0,1,1},
                        {0,0,0},
                        {1,1,1},
                        {0,1,0}};
        //int [][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        Solution s = new Solution();
        int count = s.numDistinctIslands(grid);
        System.out.println(count);
    }

    int [][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0) {return 0;}
        int count = 0;

        Set<String> set = new HashSet();
        for(int i =0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(grid[i][j] == 0) {continue;}
                StringBuilder sb = new StringBuilder();
                traverseIsland(grid, i, j, 0, 0, sb);
                String steps = sb.toString();
                if(!set.contains(steps)) {
                    set.add(steps);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverseIsland(int [][] grid, int i, int j, int x, int y, StringBuilder sb) {

        if(i < 0 || i>= grid.length || j<0 || j>=grid[0].length) {
            return;
        }

        grid[i][j] = 0;
        sb.append(x+""+y);

        for(int k =0; k<dirs.length; k++) {
            int xStep  =  dirs[k][0];
            int yStep = dirs[k][1];
            int newX = i + xStep;
            int newY = j + yStep;

            if(newX < 0 || newX >=grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 0) {continue;}

            traverseIsland(grid, newX, newY, x+xStep, y+yStep, sb);

        }
    }
}
