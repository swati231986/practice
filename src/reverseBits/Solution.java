package reverseBits;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int result = s.reverseBits(43261596);

        System.out.println(result);
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int x = n & 1;
            result = result + x;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
    /*public int reverseBits(int n) {
        StringBuilder result = new StringBuilder();

        /*while(n> 0) {
            if(n%2 == 0) {
                result.append("0");
            } else {
                result.append("1");
            }
            n = n >> 2;
        }*/

        /*while(n>0) {
            int t = n%10;
            result.append(t);
            n = n/10;
        }


        int finalResult = 0;

        for(int i = result.length() -1 ;i>=0; i--) {
            Character c = result.charAt(i);
            finalResult = finalResult + Integer.parseInt(c.toString()) * (int)Math.pow(2, result.length() - i - 1);
        }

        return finalResult;
    }*/
}
