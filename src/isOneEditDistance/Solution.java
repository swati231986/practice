package isOneEditDistance;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
            //boolean result = s.isOneEditDistance("teacher","detacher");
        boolean result = s.isOneEditDistance("ab","acd");
        System.out.println(result);
    }


    public boolean isOneEditDistance(String s, String t) {
        if((s.equals("") && t.equals("")) || s == null || t == null) {
            return false;
        }
        int diff = 0;

        int diffLength = Math.abs(s.length() - t.length());
        if(diffLength > 1) {return false;}

        if(t.length() > s.length()) {
            String temp = s;
            s = t;
            t = temp    ;
        }


        for(int i = 0; i<t.length(); i++) {
            if(s.charAt(i) == t.charAt(i)) {
                continue;
            }

            if(s.length() == t.length()) {
                return s.substring(i+1).equals(t.substring(i+1));
            } else {
                return s.substring(i+1).equals(t.substring(i));
            }
        }
        return (s.length() == t.length());
    }

}
