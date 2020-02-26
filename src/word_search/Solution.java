package word_search;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String []args) {
        Solution s = new Solution();
        //char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        /*char board[][] = {{'A','B'},
                          {'C','D'}};*/
        char board[][] = {{'a','b'},{'c','d'}};
        boolean exists = s.exist(board, "cdba");
        System.out.println(exists);
    }

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0) {return true;}
        boolean [][]visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(exist(board, i, j, word, 0, visited)) {return true;}
                }
            }
        }
        return false;
    }


    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if(index == word.length()) {return true;}

        if(i <0 || j <0 || i >= board.length || j >= board[0].length || visited[i][j] || index >= word.length() || board[i][j] != word.charAt(index) ) {
            return false;
        }

        System.out.println("i= "+i+" j= "+j+ " index= "+index );

        visited[i][j] = true;


        if(exist(board, i-1,j, word, index+1, visited)
                || exist(board, i+1, j, word, index+1, visited)
                || exist(board, i, j-1, word, index+1, visited)
                || exist(board, i, j+1, word, index+1, visited)) {

            return true;
        }
        visited[i][j] = false;

        return false;

    }


}
