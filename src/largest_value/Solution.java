package largest_value;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(9);
        List<Integer> list = largestValues(root);

        list.forEach(e -> System.out.println(e));

        root = null;
        list = largestValues(root);

        list.forEach(e -> System.out.println(e));

        root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        list = largestValues(root);

        list.forEach(e -> System.out.println(e));

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValue = new ArrayList();

        if(root == null) {
            return largestValue;
        }
        largestValue.add(root.val);
        populateLargestValue(root, largestValue, 0 );
        return largestValue;
    }

    public static void populateLargestValue(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return;
        }
        if(level >= list.size()) {
            list.add(level,root.val);
        }else if(list.get(level) < root.val) {
            list.remove(level) ;
            list.add(level, root.val);
        }
        populateLargestValue(root.left, list, level+1);
        populateLargestValue(root.right, list, level+1);
    }
}
