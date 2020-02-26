package keyboard_sol_4;

public class Solution {

    public int maxA(int N) {
        int[] dp = new int[N+1];
        if(N == 0 ||  N==1 || N == 2 || N == 3) {return N;}

        dp[0] = 0;


        for(int i = 1; i<N+1; i++) {
            dp[i] = dp[i-1] +1;
            for(int j = 1;j<i-1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
            }

        }

        return dp[N];
    }

    public static void main(String []args) {
        Solution s = new Solution();
        int result = s.maxA(7);
        System.out.println(result);
    }
}
