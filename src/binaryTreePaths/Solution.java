package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Solution s = new Solution();
        List<String> paths = s.binaryTreePaths(root);
        for(String path:paths) {
            System.out.println(path);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {return new ArrayList();}
        List<String> paths = new ArrayList<>();

        binaryTreePaths(root, "", paths);
        return paths;

    }

    private void binaryTreePaths(TreeNode node, String sb, List<String> paths) {

       if(isLeafNode(node)) {
            paths.add(sb + node.val);
        }

        if(node.left != null) {
            binaryTreePaths(node.left, sb + node.val + "->", paths);
        }

        if(node.right != null) {
            binaryTreePaths(node.right, sb + node.val + "->", paths);
        }

    }

    private boolean isLeafNode(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
