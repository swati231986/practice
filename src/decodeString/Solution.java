package decodeString;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //String str = s.decodeString("3[a]2[bc]");
        //String str = s.decodeString("100[leetcode]");
        String str = s.decodeString("3[a10[bc]]");
        System.out.println(str);
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int index = 0;

        Stack<Integer> numStack = new Stack();
        Stack<String> wordStack = new Stack();
        int num = 0;
        StringBuilder res = new StringBuilder();

        while (index < s.length()) {

            if (s.charAt(index) == '[') {
                num = 0;
                wordStack.push(res.toString());
                res = new StringBuilder();
                index++;

            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(wordStack.pop());
                int count = numStack.pop();

                while (count > 0) {
                    temp.append(res);
                    count--;
                }

                res = new StringBuilder(temp);
                index++;

            } else if (Character.isDigit(s.charAt(index))) {

                while (Character.isDigit(s.charAt(index))) {

                    num = num * 10 +  Character.getNumericValue(s.charAt(index++));

                }
                numStack.push(num);
            } else {
                res.append(s.charAt(index++));
            }
        }

        return res.toString();
    }
   /* public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<String>();



        for(Character c:s.toCharArray()) {
            if(c == ']') {
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0)) || !"[".equals(stack.peek())) {
                    temp.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder x = new StringBuilder(temp);

                StringBuilder num = new StringBuilder();

                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0,stack.pop());
                }
                int i = Integer.parseInt(num.toString());

                while(i >1) {
                    temp.append(x);
                    i--;
                }
                stack.push(temp.toString());

            } else {
                stack.push(c.toString());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }*/
}
