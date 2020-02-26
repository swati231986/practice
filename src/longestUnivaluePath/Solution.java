package longestUnivaluePath;

public class Solution {

    public static void main(String [] args) {}
        int len = 0;
    int max = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) {return 0;}
        int path = pathLength(root);
        //int max = Math.max(path, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
        return len;
    }


    private int pathLength(TreeNode node) {
        if(node == null) {return 0;}
        int left = 0;
        int right = 0;
        if(node.left != null && node.val == node.left.val) {
            left = pathLength(node.left);
        }
        if(node.right != null && node.val == node.right.val) {
            right = pathLength(node.right);
        }
        len = Math.max(len, left + right);
        return 1 + Math.max(left, right);

    }
}
