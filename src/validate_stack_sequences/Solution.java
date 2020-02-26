package validate_stack_sequences;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        int [] pushed = {1,2,3,4,5};
        int [] popped = {4,5,3,2,1};

        boolean response = validateStackSequences(pushed, popped);
        System.out.println(response);

        int [] pushed1 = {1,2,3,4,5};
        int [] popped1 = {4,3,5,1,2};
        response = validateStackSequences(pushed1, popped1);
        System.out.println(response);


        int [] pushed2 = {4,0,1,2,3};
        int [] popped2 ={4,2,3,0,1};
        response = validateStackSequences(pushed2, popped2);
        System.out.println(response);


    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 || popped.length == 0) {return true;}

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int num:pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[count]) {
                stack.pop();
                count++;
            }
        }

        return stack.isEmpty();

    }

}
