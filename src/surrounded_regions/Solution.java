package surrounded_regions;

import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        /*char[][]board = {{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};*/

        //char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        char[][] board = {  {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X','X','X','X','X','O','O','O','X','X','X','X','X','X','X','X'},
                            {'X','O','O','O','X','O','X','O','X','X','X','X','X','X','X','X'},
                            {'X','O','X','O','X','O','X','O','O','O','X','X','X','X','X','X'},
                            {'X','O','X','O','O','O','X','X','X','X','X','X','X','X','X','X'},
                            {'X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};

        char [][] modifiedBoard = s.solve(board);
        Stream.of(modifiedBoard).forEach(e ->{
            System.out.println();
            Stream.of(e).forEach(element -> System.out.print(element));
        });
    }

    public char[][] solve(char[][] board) {
        if(board.length == 0) {return null;}

        for(int i =0; i<board.length; i++) {
            if(i == 0 || i == board.length-1) {
                for(int j = 0; j<board[0].length; j++) {
                    markRegions(board, i, j);
                }
            } else {
                markRegions(board, i, 0);
                markRegions(board, i, board[i].length-1);
            }
        }

        for(int i =0; i<board.length; i++) {
            for(int j =0; j<board[i].length; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return board;

    }

    private void markRegions(char [][]board, int i, int j) {
        if(i <0 || i >= board.length || j<0 || j>=board[0].length) {
            return;
        }
        if(board[i][j] == 'O') {
            System.out.println("i = "+i+" j = "+j);
            if(i== 1 && j ==5) {
                System.out.println("");
            }
            board[i][j] = '1';
        } else {
            return;
        }
        if(i >= 0 && i < board.length && j-1 >= 0 && j-1 < board[i].length ) {
            markRegions(board, i, j-1);
        }
        if(i >= 0 && i < board.length && j+1 >= 0 && j+1 < board[i].length ) {
            markRegions(board, i, j+1);
        }
        if(i-1 >= 0 && i-1 < board.length && j >= 0 && j < board[i-1].length ) {
            markRegions(board, i-1, j);
        }
        if(i+1 >= 0 && i+1 < board.length && j >= 0 && j < board[i+1].length ) {
            markRegions(board, i+1, j);
        }


    }
}
