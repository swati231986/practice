package right_side_view;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);*/


        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.left = new TreeNode(3);
        List<Integer> nodes = s.rightSideView(root);
        nodes.forEach(e -> System.out.println(e));

    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {return new ArrayList();}

        List<Integer> nodes = new ArrayList<Integer>();
        nodes.add(root.val);
        if(root.right == null && root.left == null) {
            return nodes;
        }
        if(root.right == null) {
            rightBoundary(root.left, nodes);
        } else {
            rightBoundary(root.right, nodes);
            int size = nodes.size()-1;
            root = root.left;
            while(root != null && size>0) {
                if(root.right == null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
                size--;
            }
            if(root != null) {nodes.add(root.val);
                if(root.right == null) {
                    rightBoundary(root.left, nodes);
                } else {
                    rightBoundary(root.right, nodes);
                }
            }
        }
        return nodes;

    }

    private void rightBoundary(TreeNode node, List<Integer> list) {
        if(node == null ) {return;}

        list.add(node.val);
        if(node.right == null ) {
            rightBoundary(node.left, list);
        } else {
            rightBoundary(node.right, list);
        }
    }

}
