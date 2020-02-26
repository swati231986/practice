package maximumSwap;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int result = s.maximumSwap(2736);

        System.out.println(result);
    }

    public int maximumSwap(int num) {

        if(num == 0) {return 0;}

        char[] chars = Integer.toString(num).toCharArray();

        Map<Character, Integer> map = new HashMap();

        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            map.put(c, i);
        }

        for(int i =0; i<chars.length; i++) {
            char c = chars[i];
            for(char j='9'; j>='0'; j--) {
                if(map.containsKey(j) && map.get(j) > i && c < j) {
                    char temp = c;
                    chars[i] = j;
                    chars[map.get(j)] = temp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }

        return num;
    }
    /*public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }*/
}
