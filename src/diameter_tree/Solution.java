package diameter_tree;

public class Solution {
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        /*TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left =  new TreeNode(2);
        root.left.left.left =  new TreeNode(3);*/

        Solution s = new Solution();
        int diameter = s.diameterOfBinaryTree(root);
        System.out.println(diameter);
    }
    int max =Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {return 0;}


        diameter(root);
        return max;
    }

    public int diameter(TreeNode node) {
        if(node == null) {
            return 0;
        }
       //if(node.left != null && node.right == null) {return 1;}
        int diameterLeft = diameter(node.left) ;
        int diamenterRight = diameter(node.right) ;
        max  = Math.max(max, diamenterRight+diameterLeft );
        return Math.max(diamenterRight, diameterLeft) +1;
    }
}
