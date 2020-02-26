package flatten;

public class Solution {

    public static void main(String []args){
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        s.flatten(root);
    }
    /*public void flatten(TreeNode root) {
        if(root == null) {return;}
        TreeNode newRoot = flattenTree(root);
        root = newRoot;
        System.out.println();
    }*/

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

/*
    public TreeNode flattenTree(TreeNode node) {
        if(node == null) {return null;}

        TreeNode list = new TreeNode(node.val);
        if(node.left!=null) {
            list.right = flattenTree(node.left);
            list.left = null;
            if(node.right != null) {
                TreeNode x = list;
                while(x.right != null) {
                    x = x.right;
                }
                x.right = flattenTree(node.right);
                x.left = null;
            }
        } else if(node.right != null) {
            if(node.right != null) {
                TreeNode x = list;
                while (x.right != null) {
                    x = x.right;
                }
                x.right = flattenTree(node.right);
                x.left = null;
            }
        }


        return list;
    }*/
}
