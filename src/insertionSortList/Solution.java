package insertionSortList;

import java.util.List;

public class Solution {

    public static void main(String[]args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(1);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next = new ListNode(9);

        Solution s = new Solution();
        ListNode newList = s.insertionSortList(root);
        while (newList!=null) {
            System.out.print(" "+newList.val+" ->");
            newList = newList.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
