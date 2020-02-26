package rotate_list;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = rotateRight(head,1);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode node = head;
        int count = 0;
        while (node != null) {
            stack.push(node);
            node = node.next;
            count++;
        }

        int x = k % count;
        if (x == 0) {
            return head;
        }

        ListNode last = head;
        while (last != null && last.next != null && x > 0) {
            last = last.next;
            x--;
        }

        ListNode newHead = last.next == null ? last : last.next;
        last.next = null;
        ListNode newEnd = newHead;
        while (newEnd.next != null) {
            newEnd = newEnd.next;
        }

        newEnd.next = head;

        return newHead;
    }

    /*public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) {return null;}
        if(k == 0) {return head;}

        Stack<ListNode> stack  = new Stack<ListNode>();

        ListNode node = head;
        int count = 0;
        while(node != null) {
            stack.push(node);
            node = node.next;
            count++;
        }

        int x = k %count;

        node = stack.pop();
        if(!stack.isEmpty()) {
            node.next = head;
        }


        while(!stack.isEmpty() && x>1) {
            ListNode currentNode = stack.pop();
            currentNode.next = node;
            node = currentNode;
            x--;
        }
        if(!stack.isEmpty()) {
            ListNode lastNode = stack.pop();
            lastNode.next = null;
        }

        return node;

        /*Queue<ListNode> queue = new LinkedList();

        while(!stack.isEmpty()) {
            node = stack.pop();
            queue.add(node);
        }


        for(int i =0; i<x; i++) {
            node = queue.remove();
            queue.add(node);
        }

        ListNode prev = queue.remove();
        prev.next = null;

        while(!queue.isEmpty()) {
            node = queue.remove();
            node.next = prev;
            prev = node;
        }

        return prev;
    }*/


}
