package walls_and_gates;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        s.wallsAndGates(rooms);
    }

    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) {return;}
        boolean visited[][] = new boolean[rooms.length][rooms[0].length];

        for(int i =0; i<rooms.length; i++) {
            for(int j =0; j<rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(new Location(i,j), 1, rooms, visited);
                }
            }
        }

        for(int []row: rooms) {
            System.out.println();
            for(int i:row) {
                System.out.print(i+" ");
            }
        }
    }

    private void dfs(Location loc, int index, int[][]rooms, boolean[][]visited) {

        int i = loc.x; int j = loc.y;
        int num = rooms[i][j];
        if(num == -1 ||index > rooms[i][j]) {
            return;
        }

        if(visited[i][j]) {return;}
        if(num !=0) {
            rooms[i][j] = Math.min(index, rooms[i][j]);

        }
        visited[i][j] = true;
        if(i - 1 >= 0  && rooms[i-1][j] != -1 && rooms[i-1][j] != 0) {
            dfs(new Location(i-1,j), index+1,rooms, visited);

        }
        if(i + 1 < rooms.length  && rooms[i+1][j] != -1 && rooms[i+ 1][j] != 0) {
            dfs(new Location(i+1,j), index+1,rooms, visited);
        }
        if(j - 1 >=0   && rooms[i][j-1] != -1 && rooms[i][j-1] != 0) {
            dfs(new Location(i,j-1), index+1,rooms, visited);
        }

        if(j + 1 < rooms[0].length  && rooms[i][j+1] != -1 && rooms[i][j+1] != 0) {
            dfs(new Location(i,j+1), index+1,rooms, visited);
        }
    }
    /*public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0) {return;}
        Queue<Location> queue = new LinkedList();

        for(int i =0; i<rooms.length; i++) {
            for(int j =0; j<rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    queue.add(new Location(i,j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Location loc = queue.remove();
            if(loc != null) {
                int i = loc.x; int j = loc.y;
                int num = rooms[i][j];
                num++;
                if(i - 1 >= 0  && rooms[i-1][j] != -1 && rooms[i-1][j] != 0) {
                    rooms[i-1][j] = Math.min(num,  rooms[i-1][j]);
                    if(rooms[i-1][j] == num) { queue.add(new Location(i-1,j));}

                }
                if(i + 1 < rooms.length  && rooms[i+1][j] != -1 && rooms[i+ 1][j] != 0) {
                    rooms[i+1][j] = Math.min(num,  rooms[i+1][j]);
                    if(rooms[i+1][j] == num){queue.add(new Location(i+1,j));}
                }
                if(j - 1 >=0   && rooms[i][j-1] != -1 && rooms[i][j-1] != 0) {
                    rooms[i][j-1] = Math.min(num,  rooms[i][j-1]);
                    if(rooms[i][j-1] == num) {queue.add(new Location(i,j-1));}
                }

                if(j + 1 < rooms.length  && rooms[i][j+1] != -1 && rooms[i][j+1] != 0) {
                    rooms[i][j+1] = Math.min(num,  rooms[i][j+1]);
                    if(rooms[i][j+1] == num) {queue.add(new Location(i,j+1));}
                }
            }
        }

        for(int []row: rooms) {
            System.out.println();
            for(int i:row) {
                System.out.print(i+" ");
            }
        }
    }*/

    class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

