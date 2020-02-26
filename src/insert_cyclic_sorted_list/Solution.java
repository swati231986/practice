package insert_cyclic_sorted_list;

public class Solution {
    public static void main(String []args) {
        Solution s = new Solution();
        /*Node head = new Node(3, null);
        Node node = new Node(4, new Node(1, head));
        head.next = node;*/

        Node head = new Node(5, null);
        Node node = new Node(3, new Node(3, head));
        head.next = node;
        Node newHead = s.insert(head, 0);

        Node temp = newHead;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while (temp != newHead);
    }

    public Node insert(Node head, int insertVal) {

        if(head == null) {
            Node node = new Node(insertVal, null);
            return node;
        }

        Node nodeInserted = new Node(insertVal, null);
        Node returnHead = head;
        if(head.next == head) {
            nodeInserted.next = head;
            head.next = nodeInserted;
            return head;
        }

        Node prev = head;
        head = head.next;

        while(head.val >= prev.val) {
            head = head.next;
            prev = prev.next;
        }

        if( insertVal < head.val) {
            prev.next = nodeInserted;
            nodeInserted.next = head;
            return nodeInserted;
        }

        if((insertVal > prev.val && insertVal > head.val)) {
            prev.next = nodeInserted;
            nodeInserted.next = head;
            return returnHead;
        }



        while(insertVal > head.val) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = nodeInserted;
        nodeInserted.next = head;
        return  returnHead;

        // if start is null, create a node pointing to itself and return
        /*if (start == null) {
            Node node = new Node(x, null);
            node.next = node;
            return node;
        }
        // if start is not null, try to insert it into correct position
        // 1st pass to find max node
        Node cur = start;
        while (cur.val <= cur.next.val && cur.next != start)
            cur = cur.next;
        // 2nd pass to insert the node in to correct position
        Node max = cur;
        Node dummy = new Node(0, max.next); // use a dummy head to make insertion process simpler
        max.next = null; // break the cycle
        cur = dummy;
        while (cur.next != null && cur.next.val < x) {
            cur = cur.next;
        }
        cur.next = new Node(x, cur.next); // insert
        Node newMax = max.next == null ? max : max.next; // reconnect to cycle
        newMax.next = dummy.next;
        return start;*/

    }
}
