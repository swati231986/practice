package level_order_traversal;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String [] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/

        List<List<Integer>> levelOrderTraversal = levelOrder(root);
        levelOrderTraversal.forEach(e ->{
            System.out.println();
            e.forEach(node -> System.out.print(" "+node));
        } );
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    /*public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        int level = 0;
        if(root == null) {return null;}
        queue.add(root);
        queue.add(null);
        List<List<Integer>> returnList = new ArrayList();
        List list = new ArrayList();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == null ) {
                returnList.add(level, list);
                level++;
                list = new ArrayList();
                if(!queue.isEmpty()) {queue.add(null);}
            } else {
                list.add(node.val);
                if(node.left != null) {queue.add(node.left);}
                if(node.right != null) {queue.add(node.right);}
            }

        }
        return returnList;
    }*/
}
