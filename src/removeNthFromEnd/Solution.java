package removeNthFromEnd;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = null;
        //head.next = new ListNode(2);
        //head.next.next = null;
        ListNode newList = s.removeNthFromEnd(head, 1);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //if(head == null || head.next == null) {return null;}

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for(int i =1; i<=n+1; i++) {
            second = second.next;
        }

        while(second!=null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) {return null;}


        ListNode curr = head;
        ListNode currNext = head;

        int mid = 1;
        while(currNext != null && currNext.next != null) {
            curr = curr.next;
            currNext = currNext.next.next;
            mid++;
        }

        int size  = 0;
        if(currNext != null && currNext.next == null) {
            size = mid * 2 - 1;
        } else if(currNext == null || currNext.next.next == null) {
            mid--;
            size = 2 * mid;
        }

        int numOfHoops = size - n;
        curr = head;
        ListNode prev = curr;
        for(int i = 1; i<numOfHoops; i++ ) {
            prev = curr;
            curr = curr.next;
        }
        if(n == size) {
            head = head.next;
            return head;
        }
        if(n == 1) {
            prev.next = null;
            return head;
        }
        ListNode temp = curr;
        curr = curr.next;
        temp.next = curr.next;

        return head;
    }*/
}
