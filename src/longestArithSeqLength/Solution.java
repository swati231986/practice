package longestArithSeqLength;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {9,4,7,2,10}    ;
        int result = s.longestArithSeqLength(A);
        System.out.println(result);
    }
    /*public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }*/

    public int longestArithSeqLength(int[] A) {

        if(A.length == 0) {return 0;}

        Map<Integer, Integer>[] mapArray = new HashMap[A.length];
        int result = 0;
        for(int i =0; i<A.length; i++) {
            mapArray[i]= new HashMap();

            for(int j =0; j<i; j++) {
                int diff = A[i] - A[j];

                if(mapArray[j].containsKey(diff)) {
                    int count = mapArray[i].get(diff);
                    mapArray[i].put(diff, count+1);
                } else {
                    mapArray[i].put(diff, 2);
                }
                result = Math.max(result, mapArray[i].get(diff));
            }
        }

        return result;
    }
}
