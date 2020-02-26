package max_diff_node_ancestor;

public class Solution {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        Solution s = new Solution();
        int maxDiff = s.maxAncestorDiff(root);

    }

    int ret = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return ret;
    }
    private void helper(TreeNode curr, int min, int max){
        if(curr != null){
            ret = Math.max(ret, Math.abs(min - curr.val));
            ret = Math.max(ret, Math.abs(max - curr.val));
            if(curr.left != null)
                helper(curr.left, Math.min(min, curr.left.val), Math.max(max, curr.left.val));
            if(curr.right != null)
                helper(curr.right, Math.min(min, curr.right.val), Math.max(max, curr.right.val));
        }
    }

    /*int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root  == null) {return 0;}
        findMaxAncestorDiff(root, root);
        return max;
    }

    public void findMaxAncestorDiff(TreeNode ancestor, TreeNode node) {

        if(ancestor == null) {
            return;
        }
        if(ancestor.left == null && ancestor.right == null) {
            return;
        }


        int diff = Math.abs(ancestor.val - node.val);
        max = Math.max(diff, max);
        if(node.left != null) {findMaxAncestorDiff(ancestor, node.left);};
        if(node.right != null) {findMaxAncestorDiff(ancestor, node.right);};

        if(node == ancestor) {
            findMaxAncestorDiff(ancestor.left, ancestor.left);
            findMaxAncestorDiff(ancestor.right, ancestor.right);
        }


    }*/
}
