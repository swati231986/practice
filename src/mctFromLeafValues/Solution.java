package mctFromLeafValues;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        int[] arr = {6,2,1,4};
        Solution s = new Solution();
        int result  = s.mctFromLeafValues(arr);
        System.out.println(result);
    }

    public int mctFromLeafValues(int[] A) {
        int res = 0, n = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    /*public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i ++) {
            int localMax = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }
        for(int len = 1; len < arr.length; len ++) {
            for(int left = 0; left + len < arr.length; left ++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                if(len == 1) {
                    dp[left][right] = arr[left]*arr[right];
                } else {
                    for(int k = left; k < right; k ++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }*/
}
