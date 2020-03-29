package maximum_binary_tree_2;

public class Solution {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);*/

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(1);
        Solution s = new Solution();
        TreeNode newRoot = s.insertIntoMaxTree(root, 3);
        System.out.println("");
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = recur(root, val, null);
        if(node != null) {
            root = node;
        }
        return root;
    }

    private TreeNode recur(TreeNode node, int val, TreeNode prev) {
        if(node == null) {
            return null;
        }
        if(val < node.val) {
            if(node.left == null) {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
                return null;
            }
            if(node.right == null) {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
                return null;
            }

            int left = node.left.val; int right = node.right.val;
            if(left > right) {
                recur(node.left, val, node);
            } else {
                recur(node.right, val, node);
            }
        } else {
            TreeNode newNode = new TreeNode(val);
            if(prev == null) {
                newNode.left = node;
                return newNode;
            }
            if(prev.left == node) {
                prev.left = newNode;
                newNode.left = node;
                return null;
            } else {
                prev.right = newNode;
                newNode.right = node;
                return null;
            }
        }
        return null;
    }
}
