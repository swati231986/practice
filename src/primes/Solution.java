package primes;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int count = s.countPrimes(499979);
        System.out.println(count);
    }

    public int countPrimes(int n) {
        int count = 0;
        for(int i =1; i< n; i++) {
            if(isPrime(i)) {count++;}
        }
        return count;
    }

    private boolean isPrime(int n) {
        System.out.println(n);
        if(n ==1 ) {return false;}
        if(n == 2 || n == 3) {return true;}

        int x = n/2;

        for(int i = 2; i<=x; i++) {
            if(n%i == 0 && i != n) {return false;}
        }
        return true;
    }
}
