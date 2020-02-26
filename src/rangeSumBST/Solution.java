package rangeSumBST;

public class Solution {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if( root.val >= L && root.val <= R) {
            sum = root.val;
        }
        if (L < root.val) {
            sum = sum +  rangeSumBST(root.left, L, R);
        }
        if (R > root.val) {
            sum = sum +  rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        int sum = rangeSumBST(root, 7, 15);
        System.out.println(sum);
    }
}
