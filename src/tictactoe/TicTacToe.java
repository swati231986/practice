package tictactoe;

public class TicTacToe {
    char[][] tictactoe;
    boolean winnerDeclared;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n  = n;
        tictactoe = new char[n][n];
        winnerDeclared = false;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(winnerDeclared || tictactoe[row][col] != Character.MIN_VALUE) {return -1;}
        char c = Character.MIN_VALUE;
        c = player == 1 ? 'x' : '0';

        tictactoe[row][col] = c;
        char winner = findWinner(row, col);

        if(winner == Character.MIN_VALUE) {return 0;}
        return winner == 'x' ? 1 : 2;

    }

    private char findWinner (int row, int col) {

        char winner = findWinnerRow(row);
        if(winner != Character.MIN_VALUE) {return winner;}

        winner = findWinnerCol(col);
        if(winner != Character.MIN_VALUE) {return winner;}

        winner = findWinnerRightDiag();
        if(winner != Character.MIN_VALUE) {return winner;}

        winner = findWinnerLeftDiag();
        return winner;
    }

    private char findWinnerRow(int row) {
        char winner = Character.MIN_VALUE;
        //check for row and col
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(tictactoe[row][i] == Character.MIN_VALUE) {
                    break;
                }
                winner = tictactoe[row][i];
                continue;
            }
            if(tictactoe[row][i] != tictactoe[row][i-1]) {
                return Character.MIN_VALUE;

            }
        }
        if(winner != Character.MIN_VALUE) {
            winnerDeclared = true;
        }
        return winner;
    }

    private char findWinnerCol(int col) {
        char winner = Character.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(tictactoe[i][col] == Character.MIN_VALUE) {
                    break;
                }
                winner = tictactoe[i][col];
                continue;
            }
            if(tictactoe[i][col] != tictactoe[i-1][col]) {
                return  Character.MIN_VALUE;

            }
        }
        if(winner != Character.MIN_VALUE) {
            winnerDeclared = true;

        }

        return winner;
    }

    private char findWinnerRightDiag() {
        char winner = Character.MIN_VALUE;
        //check for row and col
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(tictactoe[i][i] == Character.MIN_VALUE) {
                    break;
                }
                winner = tictactoe[i][i];
                continue;
            }
            if(tictactoe[i][i] != tictactoe[i-1][i-1]) {
                return Character.MIN_VALUE;
            }
        }
        if(winner != Character.MIN_VALUE) {
            winnerDeclared = true;
        }
        return winner;
    }

    private char findWinnerLeftDiag() {
        char winner = Character.MIN_VALUE;

        for(int i = 0, j=n-1; i<n && j>=0; i++, j--) {
            if(i == 0) {
                if(tictactoe[0][j] == Character.MIN_VALUE) {
                    break;
                }
                winner = tictactoe[i][j];
                continue;
            }

            if(tictactoe[i][j] != tictactoe[i-1][j+1]) {
                return Character.MIN_VALUE;
            }
        }
        return winner;
    }

}
