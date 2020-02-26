package myAtoi;

public class Solution {
    public static void main(String [] args) {
        Solution s =  new Solution();
        int result  = s.myAtoi("2147483648");
        System.out.println(result);
    }

    public int myAtoi(String str) {

        str = str.trim();
        if(str.isEmpty()) {return 0;}
        int result = 0;
        int sign = 1;
        int i = 0;
        if(str.charAt(0) == '-' ) {
            sign = -1;
            i++;
        } else if(str.charAt(0) == '+') {
            sign = +1;
            i++;
        }

        for(; i<str.length() && str.charAt(i)-'0' >=0 && str.charAt(i) -'0'<=9; i++) {
            char c = str.charAt(i);
            if(result >= Integer.MAX_VALUE || result > Integer.MAX_VALUE /10 || (result == Integer.MAX_VALUE /10 && c-'0' > 7)) {
                if(sign > 0) return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }


            result = result * 10 + (c-'0');
        }

        return result*sign;
    }
}
