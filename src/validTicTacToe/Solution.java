package validTicTacToe;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //String [] board = {"XXX","OOX","OOX"};
        //String [] board = {"XOX","OXO","XOX"};
        String [] board = {"OXX","XOX","OXO"};
        boolean isValidTicTacToe = s.validTicTacToe(board);
        System.out.println(isValidTicTacToe);
    }
    public boolean validTicTacToe(String[] board) {
        if(board.length == 0) {return false;}

        boolean hasWon = false;
        String winner = "";
        int countX = 0;
        int countO = 0;

        for(int i = 0; i<board.length; i++) {
            String str = board[i];
            if(str.equals("XXX") || str.equals("OOO")) {
                if(hasWon) {return false;}
                hasWon = true;
                winner = str;
            }
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j<str.length(); j++) {
                if(str.charAt(j) == 'X') {
                    countX++;
                } else if(str.charAt(j) == 'O') {
                    countO++;
                }
                sb.append(board[j].charAt(i));
            }

            if(sb.toString().equals("XXX") || sb.toString().equals("OOO")) {
                if(hasWon && !sb.toString().equals(winner)) {return false;}
                hasWon = true;
                winner = sb.toString();
            }

        }


        if(countX - countO > 1 || countO-countX > 0) {return false;}
        if(hasWon && winner.equals("XXX") && countO == countX) {return false;}
        if(hasWon && winner.equals("OOO") && countX > countO) {return false;}


        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for(int i = 0; i<board.length; i++) {
            left.append(board[i].charAt(i));
            right.append(board[i].charAt(board.length-i-1)) ;

        }

        if(left.toString().equals("XXX")  || left.toString().equals("OOO") || right.toString().equals("XXX") || right.toString().equals("OOO")) {
            if(hasWon && (left.toString().equals("XXX") || left.toString().equals("OOO")) && !left.toString().equals(winner) ) {return false;}
            if(hasWon && (right.toString().equals("XXX") || right.toString().equals("OOO")) && !right.toString().equals(winner)) {return false;}
            hasWon = true;
            winner = left.toString().equals("XXX") || left.toString().equals("OOO") ? left.toString() : right.toString();
        }

        if(hasWon && winner.equals("XXX") && countO == countX) {return false;}
        if(hasWon && winner.equals("OOO") && countX > countO) {return false;}

        return true;
    }

}
