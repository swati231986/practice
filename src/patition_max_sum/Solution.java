package patition_max_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        //int A[] = {1,15,7,9,2,5,10};
        int A[] = {1,4,1,5,7,3,6,1,9,9,3};

        //int A[] = {1,15,7,2,5,10};
        //int A[] = {1,15};
        //int A[] = {1,15,17};
        int result = maxSumAfterPartitioning(A, 4);
        System.out.println(result);
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        if(A.length == 0 || K==0) {return 0;}
        populateLastKValues(A,K);
        return partition(A, K,  0, Integer.MIN_VALUE);

    }

    private static Map<Integer, Integer> myMap = new HashMap<>();

    private static void populateLastKValues(int []A, int K) {
        int max = Integer.MIN_VALUE;
        for(int i = A.length-1; i> A.length-K; i-- ) {
            int count = A.length-i;
            max = Math.max(max, A[i]);
            int sum = max * count;
            myMap.put(i, sum);
        }
    }
    private static int partition(int []A,  int k,  int start, int maxElement) {
        int maxSum = 0;


        if(myMap.containsKey(start)) {
            return myMap.get(start);
        }
        for(int i = start; i<A.length && i < start+k; i++) {
            maxElement = Math.max(maxElement, A[i]);
            int count = i-start+1;
            int sum  = (maxElement*(count));
            int nextPartition = partition(A, k, i+1, 0);
            maxSum = Math.max(maxSum, nextPartition+sum);

        }
        if(!myMap.containsKey(start)) {
            myMap.put(start, maxSum);
        }
        return maxSum;
    }
}
