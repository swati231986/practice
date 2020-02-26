package binarytreepruning;

public class BinaryTreePruning {
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        TreeNode prunedTreeRoot = pruneTree(root);
        printTree(prunedTreeRoot);
    }

    public static TreeNode pruneTree(TreeNode root) {
        TreeNode node = root;
        /*while(areLeavesIncorrect(node)) {
            node = removeIncorrectLeaves(node);
        }
        return node;*/
        return containsOne(root) ? root : null;
    }
    public static boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    public static TreeNode removeIncorrectLeaves(TreeNode root) {
        if (root==null) {
            return null;
        }
            if(root.left != null) {
                if(root.left.left == null && root.left.right == null && root.left.val == 0) {
                    root.left = null;
                } else {
                    removeIncorrectLeaves(root.left);
                }
            }
            if(root.right != null) {
                if(root.right.left == null && root.right.right == null && root.right.val == 0) {
                    root.right = null;
                } else {
                    removeIncorrectLeaves(root.right);
                }
            }

        return root;
    }

    public static boolean areLeavesIncorrect(TreeNode root) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && root.val ==0 ) {
            return true;
        }
        if(areLeavesIncorrect(root.left)) {
            return true;
        }
        if(areLeavesIncorrect(root.right)) {
            return true;
        }
        return false;
    }

    public static void printTree(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        pruneTree(root.left);
        pruneTree(root.right);
    }
}
