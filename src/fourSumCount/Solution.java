package fourSumCount;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int A[] = {-1,1,0};
        int B[] = {-1,0,1};
        int C[] = {0,0,1};
        int D[] = {-1,1,1};
        Solution s = new Solution();
        int count = s.fourSumCount(A,B,C,D);
        System.out.println(count);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }


        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                int rem = 0 - sum;
                if (map.containsKey(rem)) {
                    count = count + map.get(rem);

                }
            }
        }
        return count;
    }
}
