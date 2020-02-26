package max_depth_narray_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String []args) {

            Node node1 = new Node(5,null);
            Node node2 = new Node(6,null);
            List<Node> children = new ArrayList<Node>();
            children.add(node1);
            children.add(node2);

            Node node3 = new Node(3,children);
            Node node4 = new Node(2, null);
            Node node5 = new Node(4, null);
            children = new ArrayList<>();
            children.add(node3);
            children.add(node4);
            children.add(node5);
            Node root = new Node(1, children);

            Solution s = new Solution();
            int depth = s.maxDepth(root);
            System.out.println(depth);

    }


    public int maxDepth(Node root) {
        return findMaxDepth(root);
    }
    private int findMaxDepth(Node node) {
        if(node == null) {return 0;}
        if(node.children == null) {return 1;}
        int maxDepth = 0;
        for(Node child: node.children) {
            maxDepth = Math.max(maxDepth, (findMaxDepth(child)));
        }
        return maxDepth+1;
    }
}
