package AVL_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        AVLTree avlTree = new AVLTree(root);

        printTree(avlTree);
        avlTree.insert(new TreeNode(2));
        printTree(avlTree);
        avlTree.insert(new TreeNode(3));
        printTree(avlTree);

    }

    public static void printTree(AVLTree tree) {
        System.out.println();
        TreeNode root = tree.getRoot();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null && !queue.isEmpty() ) {
                System.out.println();
                queue.add(null);
            }
            if(node != null) {
                System.out.print(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
