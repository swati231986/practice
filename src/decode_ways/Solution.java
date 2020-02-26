package decode_ways;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int num = s.numDecodings("226");
        System.out.println(num);
        num = s.numDecodingsTry("01");
        System.out.println(num);
    }

    public int numDecodingsTry(String s) {
        if(s == null) {
            return 0;
        }

        int n =s.length();
        n++;
        int []dp = new int[n];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i =2; i<n; i++) {
            String first = s.substring(i-1,i);
            String second =s.substring(i-2,i);

            if(Integer.valueOf(first) >=1 && Integer.valueOf(first) <=9) {
                dp[i] = dp[i] + dp[i-1];
            }
            if(Integer.valueOf(second) >=10 && Integer.valueOf(second) <=26) {
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[n-1];
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
