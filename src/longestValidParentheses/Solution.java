package longestValidParentheses;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //int result = s.longestValidParentheses(")()())()()");
        int result = s.longestValidParentheses("(()");
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        if(s == null || s == "") {return 0;}
        Stack<Integer> stack = new Stack();

        int max = 0;
        for(int i = 0; i<s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i-stack.peek());
            } else {
                stack.push(i);
            }
        }
        return max;
    }

    /*public int longestValidParentheses(String s) {
        if(s == null || s == "") {return 0;}
        Stack<Integer> stack = new Stack();

        int left = -1;
        int max = 0;

        int i  =0;
        while(i <s.length()) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        max = Math.max(max, i - left);

                    } else {
                        max = Math.max(max, i-stack.peek());
                    }
                }
            }
            i++;
        }
        return max;
    }*/
}
