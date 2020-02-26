package removekdigits;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.removeKdigits("10200",1);
        System.out.println(result);
    }

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) {
            return null;
        }

        if(k == 0) {
            return num;
        }

        Stack<Character> stack = new Stack();

        for(int i =0; i<num.length();i++) {
            char c = num.charAt(i);

            while(!stack.isEmpty() && stack.peek() > c && k>0) {
                stack.pop();
                k--;
            }
            stack.add(c);
        }

        for(;k>0;k--) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        boolean hasStartingZero = true;
        /*while(!stack.isEmpty()) {
            char c = stack.pop();
            if(c != '0') {
                hasStartingZero = false;
            }
            if(!hasStartingZero) {
                sb.insert(0,c);
            }
        }*/

        for(char digit:stack) {
            if(digit != '0') {
                hasStartingZero = false;
            }
            if(!hasStartingZero) {
                sb.append(digit);
            }
        }

        if(sb.length() == 0){
            return "0";
        }

        return sb.toString();
    }
}
