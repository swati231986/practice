package intervalIntersection;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int [][]A = {{0,2},{5,10},{13,23},{24,25}};
        int [][]B = {{1,5},{8,12},{15,24},{25,26}};
        int [][]result = s.intervalIntersection(A, B);

        for(int i =0; i<result.length;i++) {
            System.out.println(result[i][0] + " "+result[i][1]);
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {


        List<List<Integer>> allIntervals = new ArrayList();

        int countA = 0;
        int countB = 0;

        while(countA < A.length && countB <B.length) {
            List<Integer> list = new ArrayList();
            list.add(Math.max(A[countA][0], B[countB][0]));
            list.add(Math.min(A[countA][1], B[countB][1]));

            if(A[countA][1] <B[countB][1]) {
                countA++;
            } else {
                countB++;
            }

            allIntervals.add(list);
        }

        int result[][] = new int[allIntervals.size()][2];
        int index = 0;
        for(List<Integer> arr: allIntervals) {
            result[index][0] = arr.get(0);
            result[index][1] = arr.get(1);
            index++;
        }

        return result;
    }
}
