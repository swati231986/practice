package max_profit_stocks;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int []prices = {3,2,6,5,0,3};
        int maxProfit = s.maxProfit(2, prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length < 2)
            return 0;
        if(k > prices.length / 2)
            return noLimit(prices);

        // hold[i][j]: For at most i transactions, the max profit on jth day with a stock in hand.
        // unhold[i][j]: For at most i transactions, the max profit on jth day without a stock in hand
        int[][] hold = new int[k+1][prices.length];
        int[][] unhold = new int[k+1][prices.length];
        for(int i = 1; i <= k; i++) {
            hold[i][0] = -prices[0];
            unhold[i][0] = 0;
            for(int j = 1; j < prices.length; j++) {
                hold[i][j] = Math.max(-prices[j] + unhold[i-1][j], hold[i][j-1]); // Buy or not buy
                unhold[i][j] = Math.max(prices[j] + hold[i][j-1], unhold[i][j-1]); // Sell or not sell
            }
        }
        return unhold[k][prices.length-1];
    }
    private int noLimit(int[] prices) { // Solution from Best Time to Buy and Sell Stock II
        int max = 0;
        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] > prices[i])
                max += prices[i+1] - prices[i];
        }
        return max;
    }

    /*public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                System.out.println(dp[i][j]);
                tmpMax =  Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }*/
}
