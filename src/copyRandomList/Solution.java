package copyRandomList;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = new Node();
        root.val = 1;

        root.next = new Node();
        root.next.val = 2;
        root.random = root.next;
        root.next.random = root.next;
        root.next.next = null;

        Node newNode = s.copyRandomList(root);
        while (newNode!=null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null) {return null;}

        Map<Node, Node> nodeMap = new HashMap();

        Node newHead = new Node(head.val, null, null);
        nodeMap.put(head, newHead);

        Node temp = head.next;
        Node prev = newHead;

        while(temp != null) {
            Node node = new Node(temp.val, null, null);
            prev.next = node;
            nodeMap.put(temp, node);
            prev = node;
            temp = temp.next;
        }

        temp = head;
        Node newTemp = newHead;

        while(temp != null && newTemp!= null) {
            Node random = temp.random;
            newTemp.random = nodeMap.get(random);
            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}
