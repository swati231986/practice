package shortestDistance;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int sh=s.shortestDistance(grid);
        System.out.println(sh);
    }

    public int shortestDistance(int[][] grid) {


        if(grid.length == 0) {return 0;}
        int numBldgs = 0;
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int [grid.length][grid[0].length];

        for(int i =0;i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    boolean[][]visited = new boolean[grid.length][grid[0].length];
                    bfs(i,j, grid, distance, reach, visited);
                    numBldgs++;
                }
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        for(int i =0;i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 0 && reach[i][j] == numBldgs) {
                    shortestDistance = Math.min(shortestDistance, distance[i][j]);
                }
            }
        }
        return shortestDistance;
    }

    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};


    private void bfs(int row, int col, int[][] grid, int[][]distance, int[][] reach, boolean[][]visited ) {
        if(row <0 || row>=grid.length || col < 0 || col>=grid[0].length ) {
            return;
        }


        Queue<int[]> queue = new LinkedList();

        queue.add(new int[]{row, col});
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size>0 ) {
                int []arr = queue.poll();
                for(int i = 0; i<directions.length; i++) {
                    int dis = distance[arr[0]][arr[1]];
                    int newRow = arr[0] + directions[i][0];
                    int newCol = arr[1] + directions[i][1];

                    if(newRow >= 0 && newRow < grid.length && (newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] != 2 && grid[newRow][newCol] != 1 && !visited[newRow][newCol])) {
                        distance[newRow][newCol] = level+distance[newRow][newCol];
                        reach[newRow][newCol]++;
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
                size--;
            }
            level++;
        }
    }
}
