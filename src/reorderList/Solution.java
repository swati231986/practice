package reorderList;


public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        /*head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);*/
        s.reorderList(head);
    }
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode temp = head;
        ListNode mid = head;

        while (temp != null && temp.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }

        ListNode prev = mid;
        mid = mid.next;
        prev.next = null;

        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        ListNode list1 = head;
        ListNode node = null;
        ListNode list2 = head;
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            list1.next = list2;
            list2.next = null;
            if (node != null) {
                node.next = list1;
            }

            node = list2;
            list1 = next1;
            list2 = next2;
        }

    }
}
