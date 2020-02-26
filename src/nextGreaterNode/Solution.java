package nextGreaterNode;

import java.util.Stack;
import java.util.stream.Stream;

public class Solution {

    public static void main(String []args) {
        ListNode head = new ListNode(8);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next  = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next  = new ListNode(1);
        head.next.next.next.next.next.next.next.next  = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next  = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next  = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

        Solution s = new Solution();
        int arr[] = s.nextLargerNodes(head);
        Stream.of(arr).forEach(e -> System.out.println(e));
    }

    int[] res;

    public int[] nextLargerNodes(ListNode head) {
        calNode(head, 0, new Stack<>());
        return res;
    }

    public void calNode(ListNode node, int index, Stack<Integer> stack) {
        if(node == null) {
            res = new int[index];
            return;
        }
        calNode(node.next, index + 1, stack);
        while(!stack.empty() && stack.peek() <= node.val)
            stack.pop();
        res[index] = stack.empty() ? 0 : stack.peek();
        stack.push(node.val);
    }
}
