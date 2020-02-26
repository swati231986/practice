package largest_bst_subtree;

public class Solution {

    public static void main(String [] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(17);

        Solution s = new Solution();
        int result = s.largestBSTSubtree(root);
        System.out.println(result);
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {return 0;}
        int count =  largestBSTSubtree(root, 0);
        return count-1;
    }

    private int largestBSTSubtree(TreeNode node, int count) {

        if(node == null || node.left == null && node.right == null) {
            return count;
        }

        if(node.left == null || node.val > node.left.val ) {
            if(node.right == null || node.val < node.right.val) {
                count++;
            } else {
                count--;
            }
        }
        int left = largestBSTSubtree(node.left, count);
        int right = largestBSTSubtree(node.right, count);
        if(node.left != null && node.left.val < node.val && node.right != null && node.right.val > node.val) {
            return left + right;
        }
        return Math.max(left, right);
    }
}
