package second_minimum;

public class Solution {
    private static int possibleResult = -1;
    private static int rootVal = -1;
    public static void main(String [] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(1);
        root.left.left.left.left = new TreeNode(3);
        root.left.left.left.right = new TreeNode(3);
        root.left.left.right.left = new TreeNode(1);
        root.left.left.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.left = new TreeNode(2);
        root.left.right.left.right = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(8);*/

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);*/

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        findSecondMinimumValue(root);
        System.out.println(possibleResult);
    }
    public static void findSecondMinimumValue(TreeNode root) {
        rootVal = root!=null? root.val: -1;
        traverseNode(root);


    }

    public static void traverseNode(TreeNode root) {



        if(root != null) {

            possibleResult = root.val != rootVal ? Math.min(root.val, possibleResult) : possibleResult;

            if(root.left != null && root.right != null) {
                if (root.val == root.left.val && root.val == root.right.val) {
                    traverseNode(root.left);
                    traverseNode(root.right);
                } else {
                    if (root.val == root.left.val || root.right.val < root.left.val) {
                        possibleResult = (possibleResult == -1) ? (rootVal != root.right.val ? root.right.val : possibleResult) : possibleResult;

                    }
                    if (root.val == root.right.val || root.left.val < root.right.val) {
                        possibleResult = (possibleResult == -1) ? (rootVal != root.left.val ? root.left.val : possibleResult): possibleResult;
                    }

                    if (root.val == root.left.val || root.left.val < possibleResult) {
                        traverseNode(root.left);
                    } else if (root.val == root.right.val || root.right.val < possibleResult) {
                        traverseNode(root.right);
                    }
                }

            }
        }

    }

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}
