package multiply_strings;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        String str = s.multiply("9","9");
        System.out.println(str);
    }

    public String multiply(String num1, String num2) {

        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){return "0";}

        int len1 = num1.length();
        int len2 = num2.length();
        int arr[] = new int[len1+len2-1];
        int index = 0;
        StringBuilder sb  = new StringBuilder();
        for(int i = len1-1; i >=0; i--) {
            index = len1 - i -1;
            for(int j = len2-1; j >=0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    arr[index] = mult + arr[len2 - 1 - j + len1 - 1 - i];
                    index++;
            }
        }

        int carry = 0;
        for(int i =0; i<arr.length; i++) {
            int x = arr[i] + carry;
            carry = x/10;
            x = x%10;
            sb.insert(0,x);
        }
        if(carry > 1){
            sb.insert(0, carry);
        }
        return sb.toString();

    }
}

