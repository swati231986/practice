package power;

public class Solution {

    public static void main(String [] args) {
       // Double result = myPow(2.10000, 2147483647);
        Double result = myPow(2.00000, 3);
        System.out.println(result);
    }

    public static double myPow(double x, int n) {
        if(x == 0) {return 0;}
        if(n == 0) {return 1;}

        boolean isNegative = n < 0 ? true : false;
        n = Math.abs(n);
        double prod = 1;
        for(int i =0; i<n/2; i++) {
            prod = prod * x;
        }

        prod = prod * prod;

        int rem = n%2;
        double rest = 1;
        for(int i =0; i<rem; i++) {
            rest = x * rest;
        }
        prod = prod * rest;

        double result  = isNegative ? (1.00/prod) : prod;

        return result;
    }
}
