import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by schaturvedi on 11/18/17.
 */
public class NQueenProblem {
    class Position {
        int row, col;
        Position (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        Position pos [] = null;

        int x = 0;
        List<List<String>> finalResult = new ArrayList<List<String>>();
        while(x<n) {
            pos = new Position[n];
            boolean hasSolution = solveNQueensUtil(n, 0, pos, x);
            if(hasSolution ) {
                //return pos;

                List<String> result=  new ArrayList();
                for(int row =0;row<n;row++) {
                    List arr = new ArrayList<>();
                    String s = new String();
                    for(int col=0;col<n;col++) {
                        if(pos[row].col == col) {
                            s = s+"Q";
                        }
                        else{
                            s=s+".";
                        }
                    }
                    result.add(s);

                }
                finalResult.add(result);
            }
            x = ++pos[0].col;

        }

        return finalResult;
    }

    public boolean solveNQueensUtil(int n, int row, Position[] pos, int c) {
        if(row == n) {
            return true;
        }
        int col = 0;
        if(row == 0) {
            col = c;
        } else {
            col = 0;
        }

        for(;col<n;col++) {
            boolean found = true;
            for(int i=0;i<row;i++) {
                if(pos[i].row == row || pos[i].col == col || ((pos[i].row+pos[i].col) == (row+col)) || (pos[i].row-pos[i].col == (row-col))) {
                    found = false;
                    break;
                }
            }
            if(found) {
                pos[row] = new Position(row, col);
                if(solveNQueensUtil(n, row+1, pos, col)) {
                    return true;
                }
            }

        }
        return false;

    }

    public static void main(String [] args) {
        System.out.println("Enter n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NQueenProblem nQueenProblem = new NQueenProblem();
        List<List<String>> result = nQueenProblem.solveNQueens(n);
        for(List pos: result) {
            System.out.println();
            for(Object s : pos) {
                System.out.print(s+" ");
            }
        }
    }
}
