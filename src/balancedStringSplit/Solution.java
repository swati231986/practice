package balancedStringSplit;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int result = s.balancedStringSplit("RRLRRLRLLLRL");
        System.out.println(result);
    }

    public int balancedStringSplit(String s) {

        if(s.isEmpty()) {return 0;}
        int start = 0;
        int end = 0;

        int count = 0;

        while(start < s.length() && end < s.length()) {
            char cStart = s.charAt(start);
            char cEnd = s.charAt(end);

            int numR = 0; int numL = 0;
            if(cStart == 'L') {
                numL++;
            } else {
                numR++;
            }
            start++;
            while(numR != numL  && start<s.length()) {
                if(cStart != s.charAt(start)) {
                    break;
                }
                if(cStart == 'L') {
                    numL++;
                } else {
                    numR++;
                }
                start++;

            }

            end = start;
            if(end >= s.length()) {
                break;
            }
            cEnd = s.charAt(end);

            if(cEnd == 'L') {
                numL++;
            } else {
                numR++;
            }
            end++;

            while(numR != numL && end<s.length()) {
                if(cEnd != s.charAt(end)) {
                    break;
                }
                if(cEnd == 'L') {
                    numL++;
                } else {
                    numR++;
                }
                end++;

            }

            count++;
            start = end;
        }

        return count;
    }
}
