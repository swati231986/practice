package calculateTime;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba");
        System.out.println(result);
    }
    public int calculateTime(String keyboard, String word) {
        if(keyboard.isEmpty() || word.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap();

        for(int i =0; i<keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }

        int sum = 0; int start = 0;

        for(int i =0; i<word.length(); i++) {
            sum = Math.abs(map.get(word.charAt(i)) - start) + sum;
            start = map.get(word.charAt(i)) ;
        }
        return sum;
    }
}
