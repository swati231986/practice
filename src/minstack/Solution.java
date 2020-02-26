package minstack;

public class Solution {

    public static void main(String [] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        MinStack minStack = new MinStack();System.out.println("null");
        minStack.push(2147483646);System.out.println("null");
        minStack.push(2147483646);System.out.println("null");
        minStack.push(2147483647);System.out.println("null");
        System.out.println(minStack.top());
        minStack.pop();System.out.println("null");
        System.out.println(minStack.getMin());
        minStack.pop();System.out.println("null");
        System.out.println(minStack.getMin());
        minStack.pop();System.out.println("null");
        minStack.push(2147483647);System.out.println("null");
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);System.out.println("null");
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();System.out.println("null");
        System.out.println(minStack.getMin());
    }
}

