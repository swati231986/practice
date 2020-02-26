package perfect_square;

public class Solution {

    public static void main(String [] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
    public static boolean isPerfectSquare(int num) {
        int count =1;
        int sum = 1;
        while(sum <= num) {
            System.out.println(sum);
            if(num == sum) {return true;}
            sum = (count +2) + sum;
            count = count + 2;
        }
        return false;
    }
}
