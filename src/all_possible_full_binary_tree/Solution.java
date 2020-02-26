package all_possible_full_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String []args) {
        Solution s = new Solution();
        List<TreeNode> result = s.allPossibleFBT(5);
        for (TreeNode treeNode : result) {
            System.out.println(treeNode.val);
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) return list;
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int leftNum = 1; leftNum <= N-1; leftNum += 2) {
            List<TreeNode> fLeft = allPossibleFBT(leftNum);
            List<TreeNode> fRight = allPossibleFBT(N-leftNum-1);
            for (TreeNode left: fLeft) {
                for (TreeNode right: fRight) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
