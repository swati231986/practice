package max_depth;

public class Solution {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = maxDepth(root);
        System.out.println(result);
    }

    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public static int maxDepth(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }
        int left = maxDepth(root.left, depth+1);
        int right = maxDepth(root.right, depth+1);
        int result =  (Math.max(left,right));
        return result;
    }
}
