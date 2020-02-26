package AVL_tree;

public class TreeNode {
    int val;
    int height;
    TreeNode(){}
    TreeNode(int val) {
        this.val = val;
        this.height = 0;
    }

    TreeNode left;
    TreeNode right;
}
