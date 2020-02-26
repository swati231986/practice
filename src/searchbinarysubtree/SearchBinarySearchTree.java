package searchbinarysubtree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchBinarySearchTree {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode subTree = searchBST(root, 2);
        System.out.println(subTree);
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode subTree = getSubTree(root, val);
        return subTree;
    }

    public static TreeNode getSubTree(TreeNode root, int val) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.remove();
            if(node != null) {
                if (node.val == val) {
                    return node;
                }
                myQueue.add(node.left);
                myQueue.add(node.right);
            }
        }

        return null;
    }
}
