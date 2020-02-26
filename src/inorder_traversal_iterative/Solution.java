package inorder_traversal_iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Solution s = new Solution();
        List<Integer> inorderTraversal = s.inorderTraversal(root);
        inorderTraversal.forEach(e -> System.out.println(e));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> inorderTraversal = new ArrayList();
        stack.add(root);
        while(!stack.isEmpty()) {
            while(root != null) {
                root = root.left;
                if(root != null) {stack.push(root);}
            }
            root = stack.pop();
            inorderTraversal.add(root.val);
            root = root.right;
            if(root != null){stack.push(root);}
        }
        return inorderTraversal;
    }
}
