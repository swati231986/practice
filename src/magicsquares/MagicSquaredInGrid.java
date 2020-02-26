package magicsquares;

public class MagicSquaredInGrid {
    public static void main(String [] args) {
        int [][]grid = {{4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}};
        int result = numMagicSquaresInside(grid);
        System.out.println(result);
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows  = grid.length;
        int count = 0;
        for(int i =0; i<=rows - 3; i++) {
            for(int j = 0; j<=grid[i].length - 3 ; j++) {
                if(grid[i][j]>9 || grid[i][j+1] >9 || grid[i][j+2]>9) {continue;}
                int sumRow1= grid[i][j]+ grid[i][j+1] + grid[i][j+2];

                if(grid[i+1][j]>9 || grid[i+1][j] >9 || grid[i+1][j+2]>9) {continue;}
                int sumRow2 = grid[i+1][j]+ grid[i+1][j+1] + grid[i+1][j+2];

                if(sumRow1 != sumRow2) {continue;}

                if(grid[i+2][j]>9 || grid[i+2][j+1] >9 || grid[i+2][j+2]>9) {continue;}
                int sumR0w3 = grid[i+2][j]+ grid[i+2][j+1] + grid[i+2][j+2];

                if(sumRow2 != sumR0w3) {continue;}

                if(grid[i][j]>9 || grid[i+1][j] >9 || grid[i+2][j]>9) {continue;}
                int sumCol1 = grid[i][j] + grid[i+1][j] + grid[i+2][j];
                if(sumR0w3 != sumCol1) {continue;}

                if(grid[i][j+1]>9 || grid[i+1][j+1] >9 || grid[i+2][j+1]>9) {continue;}
                int sumCol2= grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
                if(sumCol1 != sumCol2) {continue;}

                if(grid[i][j+2]>9 || grid[i][j+2] >9 || grid[i+2][j+2]>9) {continue;}
                int sumCol3= grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
                if(sumCol2 != sumCol3) {continue;}

                if(grid[i][j]>9 || grid[i+1][j+1] >9 || grid[i+2][j+2]>9) {continue;}
                int sumDiag1= grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                if(sumCol3 != sumDiag1) {continue;}

                if(grid[i][j+2]>9 || grid[i+1][j+1] >9 || grid[i+2][j]>9) {continue;}
                int sumDiag2= grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
                if(sumDiag1 != sumDiag2) {continue;}
                count++;
            }
        }
        return count;
    }
}
