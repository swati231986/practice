package path_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);


        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);*/


        List<List<Integer>> paths = pathSum(root, 22);

        paths.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element));
        });
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {return new ArrayList();}

        List<List<Integer>> paths = new ArrayList();
        pathSum(root, sum, 0, new ArrayList<Integer>(), paths);
        return paths;
    }

    private static void pathSum(TreeNode node, int sum, int currentSum, List<Integer> list, List<List<Integer>> paths) {
        if(node ==null) {
            return;
        } else if(node.left == null && node.right == null && currentSum == sum - node.val) {
            list.add(node.val);
            paths.add(new ArrayList(list));
            list.remove(list.size()-1);

        } else {
            list.add(node.val);

            pathSum(node.left, sum, currentSum + node.val, list, paths);
            pathSum(node.right, sum, currentSum + node.val, list, paths);

            list.remove(list.size()-1);
        }


    }
}
