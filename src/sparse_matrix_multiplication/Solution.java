package sparse_matrix_multiplication;

public class Solution {
    public static void main(String [] args) {
        int[][] A = {{ 1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0 },{0, 0, 0},{0, 0, 1}};

        int [][] result = multiply(A, B);
        for(int i = 0; i<result.length; i++) {
            System.out.println();
            for(int j = 0; j<result[i].length; j++) {
                System.out.print(result[i][j]);
            }
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int resultMatrix [][] = new int[A.length][B[0].length];

        for(int i =0; i<A.length ; i++) {
            for(int j = 0; j<B[0].length; j++) {
                int sum = 0;
                for(int x = 0; x<B.length; x++) {
                    int a = A[i][x];
                    int b = B[x][j];
                sum = A[i][x] * B[x][j] + sum;
                }
                resultMatrix[i][j] = sum;
            }

        }
        return resultMatrix;
    }

}
