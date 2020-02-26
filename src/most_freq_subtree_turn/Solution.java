package most_freq_subtree_turn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int [] freqTreeSum = s.findFrequentTreeSum(root);
        for(int i:freqTreeSum) {System.out.println(i);}
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null ) {
            int []result = {};
            return result;
        }
        List<Integer> treeSum = new ArrayList();
        findFrequentTreeSum(root, treeSum);

        Map<Integer, Integer> map = new HashMap();
        int maxFreq = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int sum: treeSum) {
            if(map.containsKey(sum)) {
                map.put(sum,map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
            maxFreq = maxFreq < map.get(sum) ?  map.get(sum) : maxFreq;
            maxSum = maxFreq == map.get(sum) ? sum : maxSum;
        }
        List<Integer> freqTreeSum = new ArrayList();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxFreq) {freqTreeSum.add(entry.getKey());}
        }
        return freqTreeSum.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findFrequentTreeSum(TreeNode node, List<Integer> list) {

        if(node == null) {return ;}

        int sum = findSum(node);
        list.add(sum);
        findFrequentTreeSum(node.left, list);
        findFrequentTreeSum(node.right,list);
    }

    private int findSum(TreeNode node) {
        if(node != null) {
            int sum = node.val + findSum(node.left) + findSum(node.right);
            return sum;
        }
        return 0;
    }
}
