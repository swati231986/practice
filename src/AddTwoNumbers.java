import java.util.Scanner;

/**
 * Created by schaturvedi on 11/12/17.
 */
public class AddTwoNumbers {

    public static void main(String [] args) {
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode temp =  null;
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the first linked list");
        n = sc.nextInt();
        for(int i =0;i<n;i++) {
            System.out.println("Enter the element of the first linked list");
            node1 = new ListNode(sc.nextInt());
            if(head1 == null) {
                head1 = node1;
            }
            if(temp != null) {
                temp.next = node1;
                node1.next = null;
            }
            temp = node1;
        }

        temp = null;
        int m = 0;
        sc = new Scanner(System.in);
        System.out.println("Enter the length of the second linked list");
        m = sc.nextInt();
        for(int i =0;i<m;i++) {
            System.out.println("Enter the element of the second linked list");
            node2 = new ListNode(sc.nextInt());
            if(head2 == null) {
                head2 = node2;
            }
            if(temp != null) {
                temp.next = node2;
                node2.next = null;
            }
            temp = node2;
        }



        ListNode result = addTwoNumbers(head1, head2);
        System.out.println("Result is :");
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode l3;
        ListNode head = null;
        int val = 0;
        int thisRemainder = 0;
        int prevRemainder = 0;
        ListNode temp = null;
        while(l1 != null && l2 != null) {
            thisRemainder = 0;
            if(l1!=null && l2 != null) {
                val = l1.val+l2.val + prevRemainder;
                thisRemainder = val/10;
                val = val%10;
                l1 = l1.next;
                l2=l2.next;
            }
            if(l1 == null && l2 != null) {
                val = l2.val%10;
                thisRemainder = l2.val/10;
                l2 = l2.next;
            }


            if(l2 == null && l1 != null) {
                val = l1.val%10;
                thisRemainder = l1.val/10;
                l1 = l1.next;
            }

            l3 = new ListNode(val);
            prevRemainder = thisRemainder;

            if(head == null) {
                head = l3;
            }
            if(temp!=null) {
                temp.next = l3;
            }
            l3.next = null;
            temp =l3;
        }


        if(thisRemainder != 0) {
            int x = thisRemainder;
            while (x!=0) {
                int y = x%10;
                l3 = new ListNode(y);

                temp.next = l3;
                l3.next = null;
                x = x/10;
            }
        }
        return head;
    }
}
