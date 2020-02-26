package level_order_reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public static void main(String []args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> nodes  = s.levelOrderBottom(root);

        nodes.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element));
        });
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {return null;}

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        int level = 0;
        List<List<Integer>> list = new ArrayList();
        while(!queue.isEmpty()) {

            TreeNode node = queue.remove();
            if(node == null) {
                if(!queue.isEmpty()) {
                    queue.add(null);
                    level++;
                }
                continue;
            }
            if(list.size() <= level) {
                List<Integer> nodes = new ArrayList<Integer>();
                nodes.add(node.val);
                list.add(level, nodes);
            } else {
                List<Integer> nodes = list.get(level);
                nodes.add(node.val);
            }

            if(node.left != null) {queue.add(node.left);}
            if(node.right != null) {queue.add(node.right);}
        }


        Collections.reverse(list);
        return list;
    }
}
