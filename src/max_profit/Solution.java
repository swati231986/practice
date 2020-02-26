package max_profit;

public class Solution {

    public static void main(String [] args) {
        int [] arr = {7,1,5,3,6,4};
        Solution s = new Solution();
        int result = s.maxProfit(arr);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {

        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int buyIndex = 0;
        int sellIndex = 1;

        int possibleBuyIndex = 0;
        int possibleSellIndex = 1;

        int count = 1;
        while(buyIndex <= sellIndex && count < prices.length) {
            if(prices[count-1] > prices[count]) {
                if(prices[buyIndex] > prices[count] ) {
                    possibleBuyIndex =count;
                }
                if(prices[sellIndex] < prices[possibleSellIndex]) {
                    sellIndex = possibleSellIndex;
                }
            } else if(prices[count-1] < prices[count]){
                if(prices[buyIndex] > prices[possibleBuyIndex] ) {
                    buyIndex = possibleBuyIndex;
                }
                if(prices[possibleSellIndex] < prices[count]) {
                    possibleSellIndex =count;
                }
            }
            count++;
        }

        if(prices[buyIndex] > prices[possibleBuyIndex]) {
            buyIndex = possibleBuyIndex;
        }
        if(prices[sellIndex] < prices[possibleSellIndex]) {
            sellIndex = possibleSellIndex;
        }

        return prices[sellIndex] - prices[buyIndex];
    }
}
