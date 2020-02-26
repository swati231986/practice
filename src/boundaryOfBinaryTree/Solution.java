package boundaryOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);*/
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> nodes = s.boundaryOfBinaryTree(root);
        nodes.forEach(e -> System.out.println(e));
    }


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        List<Integer> nodes = new ArrayList();
        nodes.add(root.val);
        getLeftNodes(root.left, nodes);
        getLeaves(root, nodes);
        getRightNodes(root.right, nodes);
        return nodes;
    }

    public void getLeftNodes(TreeNode node, List<Integer> leftNodes) {
        if(node  == null || (node.left == null && node.right == null)) {
            return;
        }

        leftNodes.add(node.val);
        if(node.left == null) {
            getLeftNodes(node.right, leftNodes);
        } else {
            getLeftNodes(node.left, leftNodes);
        }
    }

    public void getRightNodes(TreeNode node, List<Integer> rightNodes) {

        if(node  == null || (node.left == null && node.right == null)) {
            return;
        }


        if(node.right == null) {
            getRightNodes(node.left, rightNodes);
        } else {
            getRightNodes(node.right, rightNodes);
        }
        rightNodes.add(node.val);

    }

    public void getLeaves(TreeNode node, List<Integer> leaves) {
        if(node == null) {return;}
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}

