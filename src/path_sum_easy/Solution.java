package path_sum_easy;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String []args) {
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-2);

        Solution s = new Solution();
        int count = s.pathSum(root, -1);
        System.out.println(count);


        List<List<Integer>> paths = s.pathSumList(root, -1);
        paths.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element + " "));
        });
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {return 0;}

        return isSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int isSum(TreeNode node, int sum) {

        if(node == null) {
            return 0;
        }

        return (sum == node.val ? 1:0) + isSum(node.left, sum-node.val) + isSum(node.right, sum -node.val) ;

    }

    public List<List<Integer>> pathSumList(TreeNode root, int sum) {
        if(root == null) {return new ArrayList<>();}

        List<List<Integer>> paths = new ArrayList<>();
        generatePath(root, sum, new ArrayList<>(), paths);

        return paths;
    }

    private void generatePath(TreeNode node, int sum , List<Integer> list, List<List<Integer>> paths) {
        if(node == null) {return;}
        if(sum == node.val) {
            list.add(node.val);
            paths.add(new ArrayList<>(list));
            return;
        }
        list.add(node.val);
        generatePath(node.left, sum-node.val, list, paths);
        generatePath(node.right, sum-node.val, list, paths);
        list.remove(list.size()-1);
    }
}
