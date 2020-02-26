package twoSumLessThanK;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int A[]= {34,23,1,24,75,33,54,8};
        int sum = s.twoSumLessThanK(A, 60);
        System.out.println(sum);
    }


    public int twoSumLessThanK(int[] A, int K) {
        if(A.length == 0) {return 0;}
        Arrays.sort(A);

        int sum = Integer.MIN_VALUE;

        int start = 0;
        int end = A.length -1;


        while(start < end) {
            if(A[start] + A[end] >= K) {
                end--;
            } else if(A[start] + A[end] < K) {
                sum = Math.max(sum, A[start] + A[end]);
                start++;
            }
        }
        sum = sum == Integer.MIN_VALUE ? -1: sum;
        return sum;
    }
}
