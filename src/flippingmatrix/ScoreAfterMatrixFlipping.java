package flippingmatrix;

public class ScoreAfterMatrixFlipping {
    public static void main(String [] args) {
        int [][] matrix = {{0,1,1},{1,1,1},{0,1,0}};
        int maxScore =  matrixScore(matrix);
        System.out.println(maxScore);
    }

    public static int matrixScore( int [][] matrix) {
        int score = 0;

        //go over each row and see if it can be toggled
        for(int row =0; row< matrix.length; row++) {
            String binaryNumber = "";
            String binaryNumberToggled = "";
            for(int col =0; col<matrix[row].length; col++) {
                binaryNumber = binaryNumber + matrix[row][col] + "";
                int x = 1 - matrix[row][col];
                binaryNumberToggled = binaryNumberToggled + x + "";
            }
            double decimalNumber = convertBinaryToDecimal(binaryNumber);
            double decimalNumberToggled = convertBinaryToDecimal(binaryNumberToggled);
            if(decimalNumberToggled > decimalNumber) {
                for(int col =0; col<matrix[row].length; col++) {
                    matrix[row][col] = 1 - matrix[row][col] ;
                }
            }
        }


        //go over each col and see if it can be toggled
        int row = 1;
        for(int col = 0; col< matrix[row-1].length ; col++ ) {

            String binaryNumber = "";
            String binaryNumberToggled = "";
            for(row = 0; row<matrix.length; row++) {
                binaryNumber = binaryNumber + matrix[row][col] + "";
                int x = 1 - matrix[row][col];
                binaryNumberToggled = binaryNumberToggled + x + "";
            }
            double decimalNumber = convertBinaryToDecimal(binaryNumber);
            double decimalNumberToggled = convertBinaryToDecimal(binaryNumberToggled);
            if(decimalNumberToggled > decimalNumber) {

                for(row =0; row<matrix.length; row++) {
                    matrix[row][col] = 1 - matrix[row][col] ;
                }
            }
        }

        for(row = 0; row<matrix.length ; row++) {
            String binaryNumber = "";
            for (int col = 0; col<matrix[row].length;col++) {
                binaryNumber = binaryNumber + matrix[row][col] + "";
            }
            double decimalNumber = convertBinaryToDecimal(binaryNumber);
            score = score + (int)decimalNumber;
        }


        return score;

    }
    public static double convertBinaryToDecimal(String binary) {
        double decimal = 0;
        int count = 0;
        int pos = binary.length()-1;

        while (pos>=0) {
            Character c = binary.charAt(pos);
            long x = Integer.parseInt(c.toString())%10;
            decimal = decimal + x * Math.pow(2, count);
            count++;
            pos--;
        }
        return decimal;
    }
}
