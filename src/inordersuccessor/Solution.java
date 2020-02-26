package inordersuccessor;


public class Solution {

    public static void main(String []args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);

        TreeNode successor = inorderSuccessor(root, root.left);
        System.out.println(successor.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(p != null  && p.right != null) {

            return findMinimum(p.right, p.right);
        }
        if(root.left == null && root.right == null) {return null;}
        if(root == null) {return null;}
        TreeNode  successor = null;
        while(root!=null) {
            if(root.val > p.val) {
                successor = root;
                root = root.left;
            } else if(root.val < p.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    }

    public static TreeNode findMinimum(TreeNode root, TreeNode min) {
        if(root == null) {
            return min;
        }
        if(root.val < min.val) {
            min = root;
        }

        return findMinimum(root.left, min);
    }
}
