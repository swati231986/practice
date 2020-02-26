package coinChange;

import java.util.Arrays;

public class Solution {

    /*public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) {return 0;}
        int remaining = 0;
        Arrays.sort(coins);
        for(int i =coins.length - 1; i>=0; i--) {
            int count = amount/coins[i];
            remaining =   amount - (coins[i]* (amount/coins[i]));
            for(int j = i-1; j>=0; j--) {
                count = count + (remaining/coins[j]);
                remaining = remaining - (coins[j] * (remaining/coins[j]));
            }
            if(remaining == 0 ) {return count;}
        }

        return -1;
    }*/

    /*public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) {return 0;}
        return coinChange(coins, amount, 0);
    }

    private int coinChange(int []coins, int amount, int index) {
        if(amount == 0) {
            return 0;
        }
        if(index <coins.length && amount > 0) {

            int minVal = Integer.MAX_VALUE;

            int val = amount / coins[index];
            for(int i =0; i<=val; i++) {
                int result = coinChange(coins, amount - (i * coins[index]), index + 1);
                if(result != -1) {
                    minVal = Math.min(minVal, result + i);
                    //minVal = result + i;
                }
            }
            minVal = minVal == Integer.MAX_VALUE ? -1 : minVal;

            return minVal;

        }
        return -1;
    }*/

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) {return 0;}
        return coinChange(coins, amount, new int [amount]);
    }

    private int coinChange(int []coins, int amount, int count[]) {
        if(amount  == 0) {return 0;}
        if(amount < 0) {return -1;}
        if(count[amount -1] != 0) {return count[amount-1];}
        int minVal = Integer.MAX_VALUE;
        for(int coin : coins) {
            int result = coinChange(coins, amount - coin, count);
            if(result != -1) {
                minVal = Math.min(minVal, result + 1);
            }
        }
        minVal = minVal == Integer.MAX_VALUE ? -1 : minVal;
        count[amount -1] =minVal;
        return minVal;


    }

    public static void main(String [] args) {
        Solution s = new Solution();
        //int[] coins = {2,5,10,1};
       // int[] coins = {186,419,83,408};
        int[] coins = {2,5};
        //int[] coins = {431,62,88,428};

        //int result = s.coinChange(coins, 6249);
        int result = s.coinChange(coins, 12);
        System.out.println(result);
    }
}
