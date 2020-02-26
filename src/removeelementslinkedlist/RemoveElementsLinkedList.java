package removeelementslinkedlist;


public class RemoveElementsLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(   1);
        head.next = new ListNode(1);
        ListNode finalList = removeElements(head, 1);
        while(finalList != null) {
            System.out.println(finalList.val);
            finalList = finalList.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode temp = null;
        ListNode node = head;

        while(node!=null) {
            if(node.val == val) {
                if(temp != null) {
                    temp.next = node.next;
                } else {
                    //first node
                    head = head.next;
                    node = head;
                    continue;
                }

            } else {
                temp = node;
            }

            node = node.next;

        }

        return head;
    }
}
