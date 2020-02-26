package square_root;

public class Solution {
    public static void main(String [] args) {

        int x = -2>>>1;
        System.out.println(x);
        isPerfectSquare(1);
        isPerfectSquare(25);
        isPerfectSquare(39);
    }
    public static  boolean isPerfectSquare(int num) {
        /*int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }*/


        int low = 1; int high = num;
        while(low<=high) {
            int mid = (low + high )>>>1;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                low = mid+1;
            } else if( mid * mid > num) {
                high = mid -1;
            }
        }

        return false;
    }
}
