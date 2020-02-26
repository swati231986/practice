package pancake_sort;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        int [] A = {3,2,4,1};
        Solution s = new Solution();
        List<Integer> list = s.pancakeSort(A);
        for(Integer i: list) {
            System.out.println(i);
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
