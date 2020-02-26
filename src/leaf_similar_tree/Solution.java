package leaf_similar_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String []args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);


        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        Solution s = new Solution();
        boolean result = s.leafSimilar(root1, root2);
        System.out.println(result);
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList();
        getLeaves(root1, list1);
        List<Integer> list2 = new ArrayList();
        getLeaves(root2, list2);

        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i =0; i<list1.size(); i++) {
            if(list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        getLeaves(root.left, list);
        getLeaves(root.right, list);
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
    }
}
