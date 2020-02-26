package orangesRotting;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int[][]grid = { {2,1,1},
                        {1,1,0},
                        {0,1,1}};
        //int[][]grid = {{1,2}};

        int steps = s.orangesRotting(grid);
        System.out.println(steps);
    }

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 ) {
            return 0;
        }
        int rottenCount = 0;
        Queue<Location> queue = new LinkedList<Location>();
        for(int i=0; i<grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Location(i,j));
                } else if(grid[i][j] == 1) {rottenCount++;}
            }
        }

        int steps = 0;
        if(rottenCount == 0) {return 0;}
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for(int x=0; x<size;x++) {
                Location loc = queue.remove();
                if(loc != null && grid[loc.i][loc.j] == 2) {
                    int i = loc.i; int j = loc.j;
                    if(i-1 >= 0 && grid[i-1][j] == 1) {
                        grid[i-1][j] = 2;queue.add(new Location(i-1,j));
                        rottenCount--;
                    }
                    if(i+1 < grid.length && grid[i+1][j] == 1) {
                        grid[i+1][j] = 2;queue.add(new Location(i+1,j));
                        rottenCount--;
                    }
                    if(j-1 >= 0 && grid[i][j-1] == 1) {
                        grid[i][j-1] = 2;queue.add(new Location(i,j-1));
                        rottenCount--;
                    }
                    if(j+1 < grid[0].length && grid[i][j+1] == 1) {
                        grid[i][j+1] = 2;queue.add(new Location(i,j+1));
                        rottenCount--;
                    }

                }
            }

        }
        return rottenCount == 0 ? steps-1 : -1;
    }

    class Location {
        int i;
        int j;
        Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
