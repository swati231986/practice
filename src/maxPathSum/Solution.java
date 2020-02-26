package maxPathSum;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-2);

        int result = s.maxPathSum(root);
        System.out.println(result);
    }


    public int maxPathSum(TreeNode root) {
        if(root == null) {return 0;}

        int result = iterate(root);
        return result;
    }
    int max = Integer.MIN_VALUE;

    private int iterate(TreeNode node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }
        if(node.left == null && node.right == null) {
            return node.val;
        }


        int leftMax = iterate(node.left);
        int rightMax = iterate(node.right);

        int maxChildVal = Math.max(leftMax, rightMax);
        leftMax = leftMax == Integer.MIN_VALUE ? 0 : leftMax;
        rightMax = rightMax == Integer.MIN_VALUE ? 0 : rightMax;

        int sum = leftMax + rightMax + node.val;

        int maxNodeVal = Math.max(sum, maxChildVal);
        maxNodeVal = Math.max(leftMax + node.val, maxNodeVal);
        maxNodeVal = Math.max(rightMax + node.val, maxNodeVal);

        maxNodeVal = Math.max(maxNodeVal, node.val);

        max = Math.max(max, maxNodeVal);
        return maxNodeVal;
    }
}
