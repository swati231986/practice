package n_queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        List<List<String>> solution = s.solveNQueens(4);
        solution.forEach(e-> {
            System.out.println();
            System.out.println();
            e.forEach(element -> System.out.println(element));
        });
    }

    int rows[];
    // "hill" diagonals
    int hills[];
    // "dale" diagonals
    int dales[];
    int n;
    // output
    List<List<String>> output = new ArrayList();
    // queens positions
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == n) addSolution();
                    // if not proceed to place the rest
                else backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }

    /*int rows[];
    int cols[];
    int leftDiag[];
    int rightDiag[];

    List<List<String>> solution = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        if(n == 0) {return new ArrayList();}
        if(n ==1) {
            List<List<String>> result = new ArrayList();
            List<String> list = new ArrayList();
            result.add(list);
            return result;
        }

        rows = new int[n];
        cols = new int[n];
        leftDiag = new int[4*n - 1];
        rightDiag = new int [2*n -1];


        recur(0, n);
        return solution;
    }

    private void placeQueen(int row, int col, int n) {
        rows[row] = col;
        cols[col] = row;
        leftDiag[row - col + 2 * n] = 1;
        rightDiag[row+col] = 1;
    }

    private void removeQueen(int row, int col, int n) {
        rows[row] = 0;
        rows[col] = 0;
        leftDiag[row- col + 2*n] = 0;
        rightDiag[row+col] = 0;
    }


    private boolean isValid(int row, int col, int n) {
        int res = rows[row] + cols[col] + leftDiag[row - col + 2*n] + rightDiag[row+col];
        return res == 0 ? true : false;
    }


    private void prepareSolution(int n) {
        List<String> list = new ArrayList();

        for(int i = 0; i<n;i++) {
            StringBuilder sb = new StringBuilder();

            int col = rows[i];
            int j =0;
            for(j =0; j<col; j++) {
                sb.append(".");
            }

            sb.append("Q");

            for(;j<n;j++) {
                sb.append(".");
            }
            list.add(sb.toString());
        }
        solution.add(new ArrayList(list));
    }

    private void recur(int row, int n) {

        for(int col =0; col<n; col++) {

            if(isValid(row,col, n)) {
                placeQueen(row, col, n);

                if(row == n-1) {
                    prepareSolution(n);
                } else {
                    recur(row+1, n);
                }
                removeQueen(row, col, n);
            }
        }
    }*/
}
