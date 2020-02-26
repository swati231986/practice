package divide;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //int result = s.divide(-2147483648, -1);
        int result = s.divide(-2147483648, 2);
       // int result = s.divide(6, 2);
        System.out.println(result);
    }

    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    /*public int divide(int dividend, int divisor) {

        boolean isNegative = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? false : true;

        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);



        if(dividendLong == divisorLong) {
            if(isNegative) {return -1;}
            return 1;
        }

        if(divisorLong == 1) {
            if(isNegative) {
                if(dividend < 0) {
                    return dividend;
                }
                return 0-dividend;
            }
            if(dividend < 0) {
                if(dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return 0-dividend;
            }
            return dividend;
        }

        if(dividendLong < divisorLong) {
            return 0;
        }

        int result = 0;
        long sum = 0;

        while(sum+divisorLong <= dividendLong) {
            result++;
            sum = divisorLong + sum;
        }
        if(isNegative) {
            return 0-result ;
        }
        return result;

    }*/
}
