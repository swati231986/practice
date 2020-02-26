package reverseList;

public class Solution {
    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next  = new ListNode(3);
        head.next.next.next  = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Solution s = new Solution();
        ListNode newHead = s.reverseList(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    static ListNode head;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public ListNode reverseList(ListNode node, ListNode prev) {
        if(node.next == null) {
            node.next = prev;
            head = node;
            return head;
        }
        ListNode nextNode = node.next;
        node.next = prev;
        reverseList(nextNode, node);

        return head;
    }
    /*public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

       ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            ListNode nextNode = node.next;
            ListNode temp = nextNode.next;
            nextNode.next = node;
            node.next = prev;
            prev = nextNode;
            node = temp;
        }

        return prev;
    }*/
}
