package sum_of_square;

public class Solution {
    public static void main(String [] args) {
        boolean isSumOfSquare = judgeSquareSum(2);
        System.out.println(isSumOfSquare);
    }

    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);

        while(left <= right) {
            int curr = left * left + right * right;
            if(curr < c) {
                left++;

            } else if(curr > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
