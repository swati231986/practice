package add_binary;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        String result = s.addBinary("1010", "1011");
        System.out.println(result);

    }


    /*public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }*/


    public String addBinary(String a, String b) {
        int carry = 0;

        int i =a.length()-1, j=b.length() -1;

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >=0){
            sum = carry;

            if(i >=0) {
                int k = '0';
                int l = '1';
                sum = sum + a.charAt(i) - '0';
                i--;
            }

            if(j >= 0) {
                sum = sum + b.charAt(j) - '0';
                j--;
            }

            int x = sum % 2;
            carry = sum / 2;
            sb.append(x);
        }

        if(carry  != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
