package advantage_shuffle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int A[] = {12,24,8,32};
        int B[] = {13,25,32,11};
    }

    public int[] advantageCount(int[] A, int[] B) {
        if(A.length <=0 || B.length <= 0) {
            int result[] = {};
            return result;
        }
        Arrays.sort(A);
        Queue<Integer> queue = new LinkedList();

        for(int i:A) {queue.add(i);}
        int[] result = new int[A.length];
        int count = 0;
        while(!queue.isEmpty() && count<B.length) {
            int x = B[count];
            if(x < queue.peek()) {
                result[count] = queue.remove();
                count++;
            } else {
                int y = queue.remove();
                if(!queue.isEmpty() && queue.peek() > y) {
                    if(count+1 < B.length && queue.peek() > B[count+1]) {
                        result[count] = y;
                        count++;
                    } else {
                        queue.add(y);
                    }

                } else {
                    result[count] = y;
                    count++;
                }
            }

        }

        return result;
    }
}
