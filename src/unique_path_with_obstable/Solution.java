package unique_path_with_obstable;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        /*int [][] obstacleGrid = {{0,0,0},
                {0,1,0},
                {0,0,0}};*/

        int [][] obstacleGrid = {{0,0},
                {1,1},
                {0,0}};
        int result = s.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) {return 0;}

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {return 0;}
        for(int i =0; i<rows; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            obstacleGrid[i][0]  = -1;
        }
        for(int i =0; i<cols; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            obstacleGrid[0][i] = -1;
        }

        for(int i =1; i<rows;i++) {
            for(int j =1;j <cols;j++) {
                int x = obstacleGrid[i-1][j] == 1 ? 0:obstacleGrid[i-1][j];
                int y = obstacleGrid[i][j-1] == 1 ? 0:obstacleGrid[i][j-1];
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 1:x+y;
            }
        }

        return obstacleGrid[rows-1][cols-1] < 0 ? 0-obstacleGrid[rows-1][cols-1] : 0;
    }
}
