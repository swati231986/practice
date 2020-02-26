package nummatrix;

public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        this.sumMatrix = new int[matrix.length][matrix[0].length];

        for(int row = 0; row<matrix.length; row++) {

            this.sumMatrix[row][0] = matrix[row][0];
            for(int col = 1; col<matrix[row].length; col++) {
                this.sumMatrix[row][col] = matrix[row][col] + this.sumMatrix[row][col-1];
            }
        }

    }



    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i<=row2; i++) {
            sum = sum + sumMatrix[i][col2];
            if(col1>0) {
                sum = sum-sumMatrix[i][col1-1];
            }
        }
        return sum;
    }
}
