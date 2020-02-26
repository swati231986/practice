package binary_search_tree_iterator;

public class BSTIterator {
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        int min = this.root.val;
        TreeNode node = root;
        TreeNode temp = node;
        if(root.left == null && root.right == null) {
            root = null;
            return min;
        }
        while(node != null) {
            if(node.left == null) {
                if(node.equals(root)) {
                    min = root.val;
                    root = node.right;
                    return min;
                } else {
                    min = node.val;
                    temp.left = null;
                }
            }
            temp = node;
            node = node.left;
        }
        return min;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root== null) {
            return false;
        }
        return true;
    }
}
