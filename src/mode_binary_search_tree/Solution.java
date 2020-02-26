package mode_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int max = 0;
    Integer prev = null;
    int count = 0;
    List<Integer> list = new ArrayList();

    public static void main(String []args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int [] result = s.findMode(root);
        for(int n:result) {System.out.println(n);}
    }

    public int[] findMode(TreeNode root) {

        iterate(root);
        return list.stream().mapToInt(e ->e).toArray();
    }


    private void iterate(TreeNode node ) {
        if(node == null) {return;}
        iterate(node.left);

        if(prev == null) {
            prev = node.val;
            count = 1;
            list.add(node.val);
        } else if(prev == node.val){
            count++;
        } else {
            if( max < count) {
                list.clear();
                list.add(node.val);
                max = count;
            } else if(max == count) {
                list.add(node.val);
            }
            count = 1;
            prev = node.val;
        }
        iterate(node.right);
    }
}
