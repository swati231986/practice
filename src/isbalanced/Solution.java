package isbalanced;

public class Solution {

    public static void main(String [] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution s = new Solution();
        boolean result = s.isBalanced(root);
        System.out.println(result);
    }


    public boolean isBalanced(TreeNode node) {
        if(node == null) {return true;}
        int diff = getMaxDepth(node.left) - getMaxDepth(node.right);

        if((diff== 0 || diff == 1 || diff == -1) &&isBalanced(node.left) && isBalanced(node.right)) {return true;}
        return false;
    }

    private int getMaxDepth(TreeNode node) {
        if(node == null) {return 0;}
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }
}
