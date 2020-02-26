package splitListToParts;

import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode[] nodes = s.splitListToParts(root, 3);
        Stream.of(nodes).forEach(e -> System.out.println(e.val));
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null) {return null;}
        ListNode[] nodes = new ListNode[k];
        if(k == 0) {nodes[0] = root; return nodes;}

        int len = 0;
        ListNode node = root;
        Stack<ListNode> stack = new Stack();
        while(node != null) {
            len++;
            stack.push(node);
            node = node.next;
        }

        int lenEachList = len/k;

        if(lenEachList == 0) {
            node = root;
            int i =0;
            while(node != null) {
                nodes[i] = node;
                ListNode nodeNext = node.next;
                node.next = null;
                node = nodeNext;
                i++;
            }
            for(int j = 1; j<= k-len && i<k; j++,i++) {
                nodes[i] = null;
            }
        } else {
            int i = k-1;
            while(!stack.isEmpty()) {
                int count = 1;

                while(count <=lenEachList && !stack.isEmpty()) {
                    node = stack.pop();
                    count++;
                }
                if(stack.size() < lenEachList) {
                    while(!stack.isEmpty()) {
                        node = stack.pop();
                    }
                    nodes[i] = node;
                } else {
                    nodes[i] = node;
                }
                i--;
            }

        }

        return nodes;
    }
}
