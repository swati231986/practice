package add_strings;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        String sum = s.addStrings("510", "5100");
        System.out.println(sum);
    }
    public String addStrings(String num1, String num2) {
        if( (num1 == null || num1.length() == 0) && (num2 == null || num2.length() == 0) ) {
            return null;
        }
        if( num1 == null || num1.length() == 0 ) {
            return num2;
        }
        if( num2 == null || num2.length() == 0 ) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();

        int result = 0;
        int carry = 0;

        int count1 = num1.length()-1;
        int count2 = num2.length()-1;
        int count = 0;
        int powTen = 1;
        while(count1>=0 && count2>=0) {
            int a = num1.charAt(count1) - '0';
            int b = num2.charAt(count2) - '0';

            int sum = a + b + carry;
            carry = sum/10;
            sum = sum % 10;
            result = sum * powTen + result;
            powTen = powTen*10;
            count1--;
            count2--;
            count++;
        }

        while (count1>=0) {
            int a = num1.charAt(count1) - '0';
            int sum = carry + a;
            carry = sum/10;
            sum = sum%10;
            result = result  + sum*powTen;
            powTen = powTen*10;
            count1--;
            count++;
        }

        while (count2>=0) {
            int b = num2.charAt(count2) - '0';
            int sum = carry + b;
            carry = sum/10;
            sum = sum%10;
            result = result + powTen*sum;
            powTen = powTen*10;
            count2--;
            count++;
        }

        if(carry>0) {
            result = carry*powTen + result;
        }

        return String.valueOf(result);
    }
}
