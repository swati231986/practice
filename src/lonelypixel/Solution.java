package lonelypixel;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] picture = {{'W','W','W'},{'W','W','W'},{'W','W','B'}};
        int result = s.findLonelyPixel(picture);
        System.out.println(result);
    }
    public int findLonelyPixel(char[][] picture) {
        if(picture.length == 0) {
            return 0;
        }
        int[] rows = new int[picture.length];
        Map<Integer, Integer> rowMap = new HashMap();
        int[]cols = new int[picture[0].length];

        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                if(picture[i][j] == 'B') {
                    if(rows[i] == 0 && cols[j] == 0) {
                        rows[i] = 1; cols[j] = 1;
                        rowMap.put(i, j);
                    } else {
                        rowMap.remove(i);
                        rows[i]++;cols[j]++;
                    }
                }
            }
        }
        int count = 0; int index = 0;
        for(int row:rows) {
            if(row == 1) {
                if(rowMap.containsKey(index) && cols[rowMap.get(index)] == 1) {
                    count++;
                }
            }
            index++;
        }
        return count;
    }
}
