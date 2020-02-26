package buy_sell_stock;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] prices = {6,1,3,2,4,7};
        int maxPrice = s.maxProfit(prices);
        System.out.println(maxPrice);
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0) {return 0;}
        if(prices.length == 1) {return 0;}

        int max = prices[0];
        int min = prices[0];

        int indexMin = 0;
        int indexMax = 0;
        int prevMinIndex = 0;
        int prevMaxIndex = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b-a);

        for(int i =1; i<=prices.length; i++) {
            if(min != max) {
                if(indexMin == prevMinIndex && prevMaxIndex != indexMax && !pq.isEmpty()) {
                    pq.poll();
                }
                prevMinIndex = indexMin;
                prevMaxIndex = indexMax;
                pq.add(max-min);
            }
            if(i >= prices.length) {continue;}
            if(prices[i] < min) {
                max = prices[i];
                min = prices[i];
                indexMin = i;
                indexMax = i;
            } else if( prices[i] > max){
                max = prices[i];
                indexMax = i;
            }
        }
        int result = 0;

        if(pq.size() != 0) {
            result = pq.poll();
        }
        if(pq.size() != 0) {
            result = result + pq.poll();
        }
        return result;
    }
}
