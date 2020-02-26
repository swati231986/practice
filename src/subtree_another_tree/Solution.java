package subtree_another_tree;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
       /* TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(0);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);*/

       TreeNode root = new TreeNode(3);
        root.left =  new TreeNode(4);
        root.right =  new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        boolean result = s.isSubtree(root, root2);
        System.out.println(result);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {return true;}
        if(s == null && t != null) {return false;}
        if(s != null && t == null) {return false;}

        if(s.val == t.val ) {
            if( isSubtree(s.left, t.left) &&  isSubtree(s.right, t.right))  {
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }


    }
}
