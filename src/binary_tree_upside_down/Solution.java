package binary_tree_upside_down;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.left.left = new TreeNode(6);
        root.left.left.left.left.left.left = new TreeNode(7);
        root.left.left.left.left.left.left.left = new TreeNode(9);
        root.left.left.left.left.left.left.right = new TreeNode(8);
        root.left.left.left.left.left.left.left.left = new TreeNode(10);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode upsideDownTree = upsideDownBinaryTree(root);

        System.out.println("");
    }
    /*public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Integer> leftNodesList = new ArrayList();
        List<Integer> rightNodesList = new ArrayList();

        leftNodesList.add(root.val);

        traverseNodes(root, leftNodesList, rightNodesList);
        TreeNode newTree = new TreeNode(leftNodesList.get(leftNodesList.size()-1));
        TreeNode temp = newTree;
        for(int i =leftNodesList.size()-2 ; i>=0; i--) {
            TreeNode node = new TreeNode(leftNodesList.get(i));
            temp.right = node;
            temp = node;
        }
        temp = newTree;


        for(int i = rightNodesList.size()-1; i>=0 && temp!=null; i--) {
            TreeNode node = null;
            if(rightNodesList.get(i) != null) {
                node = new TreeNode(rightNodesList.get(i));
            }
            temp.left = node;
            temp = temp.right;
        }

        return newTree;

    }

    public static void traverseNodes(TreeNode root, List<Integer> leftNodesList, List<Integer> rightNodesList) {
        if(root == null ) {
            return;
        }
        if(root.left !=null) {
            leftNodesList.add(root.left.val);

        }
        if(root.right != null) {
            rightNodesList.add(root.right.val);
        } else if(root.left != null){
            rightNodesList.add(null);
        }
        traverseNodes(root.left, leftNodesList, rightNodesList);
        traverseNodes(root.right, leftNodesList, rightNodesList);
    }*/

    static TreeNode upsideRoot = null;
    static TreeNode upsideCurr = null;

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        upsideRoot = null;
        upsideCurr = null;
        upsideDownBinaryTreeUtil(root);
        return upsideRoot;
    }

    private static TreeNode upsideDownBinaryTreeUtil(TreeNode curr) {
        if (curr == null) {
            return curr;
        }

        TreeNode left = upsideDownBinaryTreeUtil(curr.left);
        TreeNode right = upsideDownBinaryTreeUtil(curr.right);


        if (left != null) {

            if (upsideCurr == null) {
                upsideCurr = new TreeNode(left.val);
                upsideRoot = upsideCurr;
            }

            upsideCurr.left = right == null ? null : new TreeNode(right.val);
            upsideCurr.right = new TreeNode(curr.val);

            upsideCurr = upsideCurr.right;
        } else {
            if (upsideCurr == null) {
                upsideCurr = curr;
                upsideRoot = upsideCurr;
            }
        }

        return curr;
    }
}
