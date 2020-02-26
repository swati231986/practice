package is_valid_bst;

import java.util.Stack;

public class Solution {

    public static void main(String []args) {
        /*TreeNode root = new TreeNode(3);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(15);
        root.right.left.right.right = new TreeNode(45);*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);*/

        Solution s = new Solution();
        boolean result = s.isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    /*public boolean isValidBST(TreeNode root) {
        return backtrack(root, null, null);
    }
    private boolean backtrack(TreeNode root, Integer low, Integer high){
        if(root == null) return true;
        if(low != null && root.val <= low || high != null && root.val >= high) return false;
        return backtrack(root.left,low,root.val) && backtrack(root.right,root.val,high);
    }*/

    /*public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if((root.right == null || root.val < root.right.val) && (root.left == null || root.left.val < root.val)) {
            return isValidBST(root.left, Integer.MAX_VALUE, root.val) && isValidBST(root.right, root.val, Integer.MIN_VALUE);
        }
        return false;
    }

    boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        boolean isValid = isValidBST(root.left, min, max) && isValidBST(root.right, max, max);


        if(isValid && (root.left  == null || root.val > root.left.val) && (root.right == null || root.val < root.right.val) && (root.left  == null || root.val > max) && (root.right == null || root.val < min)) {return true;}


        return false;
    }*/

    /*public boolean isValidBST(TreeNode root) {
       if(root == null) {
            return true;
        }
        int maxLeft =  getMax(root.left, Integer.MIN_VALUE);
        int minRight = getMin(root.right, Integer.MAX_VALUE);
        boolean isValid = false;
        if((root.left  == null || root.val > root.left.val) && (root.right == null || root.val < root.right.val) && (root.left  == null || root.val > maxLeft) && (root.right == null || root.val < minRight)) {isValid = true;}
        if(isValid && isValidBST(root.left) && isValidBST(root.right) ) {return true;}
        return false;
    }

    private int getMin(TreeNode node, int min) {
        if(node == null) {
            return min;
        }
        min = Math.min(node.val, min);
        return Math.min(getMin(node.left, min), getMin(node.right, min));
    }

    private int getMax(TreeNode node, int max) {
        if(node == null) {
            return max;
        }
        max = Math.max(node.val, max);
        return Math.max(getMax(node.left, max), getMax(node.right, max));
    }*/
}
