package numIslands2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        int [][] position = {{0,0}, {0,1}, {1,2}, {2,1}};
        List<Integer> islands = s.numIslands2(3,3,position);
        islands.forEach(e -> System.out.println(e));
    }

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);

        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;

            for(int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands
                    root = rootNb;          // current tree root = joined tree root
                    count--;
                }
            }

            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }
    /*public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(positions.length == 0) {return new ArrayList();}
        int islands[][] = new int[m][n];
        List<Integer> list = new ArrayList();
        int sum = 0;
        for(int i =0; i<positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];

            islands[x][y] = 1;

            int num = countIslands(islands);
            sum = sum + num;
            list.add(sum);

        }
        return list;
    }

    int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    private int countIslands(int[][] islands) {

        if(islands.length == 0) {return 0;}
        int count = 0;
        for(int i =0; i<islands.length; i++) {
            for(int j = 0; j<islands[i].length; j++) {
                boolean partOfExistingIsland = false;
                if(islands[i][j] == 1) {
                    for(int k = 0; k< dirs.length; k++) {
                        int x = dirs[k][0]; int y = dirs[k][1];
                        if(i+x >=0 && i+x <islands.length && j+y >= 0 && j+y < islands[0].length) {
                            if(islands[i+x][j+y] == -1) {
                                partOfExistingIsland = true;
                            }
                        }
                    }

                    if(!partOfExistingIsland) {
                        count++;
                        traverseIsland(islands, i, j);
                    }
                    islands[i][j] = -1;
                }
            }
        }
        return count;
    }

    private void traverseIsland(int [][] islands, int i, int j) {
        if(i<0 || j<0 || i >= islands.length || j >= islands[0].length || islands[i][j] == 0 || islands[i][j] == -1) {return;}
        islands[i][j] = -1;
        for(int k =0; k<dirs.length; k++) {
            int x = dirs[k][0]; int y = dirs[k][1];
            traverseIsland(islands, i+x, j+y);
        }
    }*/
}
