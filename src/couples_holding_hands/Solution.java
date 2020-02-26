package couples_holding_hands;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //int [] row = {0, 2, 1, 3};
        int [] row = {5, 2, 1, 4, 3, 7, 6, 0};
        int swaps = s.minSwapsCouples(row);
        System.out.println(swaps);
    }

    public int minSwapsCouples(int[] row) {
        if(row.length == 0) {return  0;}

        Map<Integer, Integer> posMap = new HashMap();

        for(int i = 0; i<row.length; i++) {
            posMap.put(row[i],i);
        }
        int count = 0;
        for(int i = 0; i<row.length-1; i=i+2) {
            int couple = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if(row[i+1] != couple) {
                int j = posMap.get(couple);
                int x = row[i+1];
                swap(row, i+1, posMap.get(couple));
                posMap.put(couple, i+1);
                posMap.put(x, j);
                count++;
            }
        }
        return count;
    }

    public void swap(int [] row, int i , int j) {
        int temp =row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}
