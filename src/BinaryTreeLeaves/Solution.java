package BinaryTreeLeaves;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right= new TreeNode(5);
        List<List<Integer>> result = findLeaves(root);
        for(List<Integer> leaves: result) {
            for (Integer leaf: leaves) {
                System.out.print(leaf + " , ");
            }
            System.out.println();
        }
    }

   /* public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList();

        while(root != null && (root.left != null || root.right != null)) {
            List<Integer> list = new ArrayList();
            removeLeaves(root, list);
            finalResult.add(list);

        }
        List<Integer> list = new ArrayList();
        list.add(root.val);
        finalResult.add(list);

        return finalResult;

    }
    public static void removeLeaves(TreeNode root, List<Integer> leaves) {
        if(root == null) {
            return;
        }

        // if the nodes has leaves
        if(root.left != null && root.left.left == null && root.left.right == null) {
            // left is a lead
            leaves.add(root.left.val);
            root.left = null;
        }
        if(root.right != null && root.right.left == null && root.right.right == null) {
            leaves.add(root.right.val);
            root.right = null;
        }
        removeLeaves(root.left, leaves);
        removeLeaves(root.right, leaves);
    }*/


    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private static int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}
