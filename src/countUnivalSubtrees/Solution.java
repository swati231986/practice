package countUnivalSubtrees;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        int c = s.countUnivalSubtrees(root);
        System.out.println(c);
    }
    public int countUnivalSubtrees(TreeNode root) {
        countSingleValSubTree(root);
        return count;
    }
    int count = 0;
    private int countSingleValSubTree(TreeNode node) {
        if(node == null) {return 0;}

        int left = countSingleValSubTree(node.left);
        int right = countSingleValSubTree(node.right);
        count = count + left + right;
        if(node.left == null && node.right  == null) {
            return 1;
        }

        if(node.left != null && node.left.val == node.val) {
            return 1;
        }
        if(node.right != null && node.right.val == node.val) {
            return 1;
        }

        return 0;
    }
}
