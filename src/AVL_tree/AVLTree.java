package AVL_tree;


public class AVLTree {

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public AVLTree(TreeNode root) {
        this.root = root;
    }

    public AVLTree() {}

    private TreeNode root;

    public void insert(TreeNode node){
        TreeNode temp = root;
        while (temp != null) {
            if(node.val <temp.val) {
                if(temp.left == null) {
                    temp.left = node;
                    node.height = temp.height+1;
                    balanceTree(true, temp);
                    break;
                }
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = node;
                    node.height = temp.height+1;
                    balanceTree(false, temp);
                    break;
                }
                temp = temp.right;
            }
        }
    }

    private void balanceTree(boolean isLeft, TreeNode treeNode){
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null) {
            int leftHeight = node.left != null ? node.left.height : 0;
            int rightHeight = node.right != null ? node.right.height : 0;
            if(leftHeight == rightHeight || Math.abs(leftHeight - rightHeight) ==1 ) {
                prev = node;
                if(isLeft) {
                    node = node.left;
                } else {
                    node =node.right;
                }
            } else {
                rotate(prev, node, isLeft);
                return;
            }
        }
    }

    private void rotate(TreeNode prev, TreeNode node, boolean isLeft) {
        if(isLeft) {
            if(node.left != null && node.left.left != null) {
                TreeNode nextNode = node.left;
                TreeNode nextToNextNode = nextNode.left;
                if(prev == null){
                    root = nextNode;
                    root.left = nextToNextNode;
                    root.right = node;
                    return;
                } else {
                    if(prev.left == node) {
                        prev.left = nextNode;
                    } else if(prev.right == node) {
                        prev.right = nextNode;
                    }
                    nextNode.right = node;
                    nextNode.left = nextToNextNode;
                }
            } else if(node.left != null && node.left.right != null) {
                TreeNode temp = node.left;
                node.left = temp.right;
                node.left.left = temp;

                TreeNode nextNode = node.left;
                TreeNode nextToNextNode = nextNode.left;
                if(prev == null){
                    root = nextNode;
                    root.left = nextToNextNode;
                    root.right = node;
                    return;
                } else {
                    if(prev.left == node) {
                        prev.left = nextNode;
                    } else if(prev.right == node) {
                        prev.right = nextNode;
                    }
                    nextNode.right = node;
                    nextNode.left = nextToNextNode;
                }
            }
        } else {
            if(node.right != null && node.right.right != null) {
                TreeNode nextNode = node.right;
                TreeNode nextToNextNode = nextNode.right;
                if(prev == null) {
                    root = nextNode;
                    root.left = node;
                    root.right = nextToNextNode;
                } else {
                    prev.right = nextNode;
                    nextNode.left = node;
                    nextNode.right = nextToNextNode;
                }

            } else if(node.right != null && node.right.left != null) {
                TreeNode temp = node.right;
                node.right = temp.left;
                node.right.right = temp;
            }
        }
    }
}
