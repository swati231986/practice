package validstringparanthesis;

import java.util.Stack;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
      //  boolean result = s.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(**");
        boolean result = s.checkValidString("(***)))()");
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

    /*public boolean checkValidString(String s) {

        if(s.isEmpty()) {return false;}

        Stack<Character> stack = new Stack();
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(c == '(' || c == '*')  {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {return false;}
                char x = stack.pop();
                if(x == '(') {index++;continue;}
                int count = 1;
                while(x != '(' && !stack.isEmpty()) {
                    x = stack.pop();
                    count++;
                }
                if(x == '(') {
                    for(int i = 1; i<count;i++) {stack.push('*');}

                } else if(x == '*') {
                    for(int i = 1; i<count;i++) {stack.push('*');}
                }
            }
            index++;
        }

        int stars = 0;
        while(!stack.isEmpty()) {
            if(stack.pop() == '(' ) {
               if(stars == 0) {return false;}
               stars--;
            }
            else {
                stars++;
            }
        }
        return true;
    }*/
}
