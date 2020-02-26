package uniqueBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        //int result = s.numTrees(7);
        //System.out.println(result);
        List<TreeNode> treeNodes = s.generateTrees(3);
        for(TreeNode tree: treeNodes) {
            System.out.println(tree.val);
        }
    }

    public int numTrees(int n) {
        if(n == 0) {return 0;}
        if(n == 1) {return 1;}
        if(n == 2) {return 2;}

        List<Integer> T = new ArrayList<>();
        T.add(1);T.add(2);

        int result = uniqueTrees(n, T);
        return result;
    }

    private int uniqueTrees(int n, List<Integer> T) {
        if(n == 0) {return 0;}
        if(T.size() >= n ) {
            return T.get(n-1);
        }
        int sum = 0;
        int x = n/2;

        if(n % 2 != 0) {
            int y = x+1;
            sum = sum + uniqueTrees(n-y, T) * uniqueTrees(y - 1, T);
        }

        for(int i = 1; i<=x; i++) {
            int a = uniqueTrees(n-i, T);
            int b = uniqueTrees(i-1, T);
            sum = b > 0 ? sum + 2*a*b : sum + 2*a;
        }
        if(n-1>0) {
            T.add(n-1, sum);
        }

        return sum;

    }

    public List<TreeNode> generateTrees(int n) {

        if(n == 0) {return new ArrayList();}
        if(n == 1) {
            TreeNode node = new TreeNode(1);
            return Arrays.asList(node);
        }
        return generateTrees(n, 1, n);
    }


    private List<TreeNode> generateTrees(int n, int start, int end) {
        List<TreeNode> subTree = new ArrayList<TreeNode>();

        if(start > end)  {
            subTree.add(null);
            return subTree;
        }
        if(start== end) {
            TreeNode node = new TreeNode(start);
            subTree.add(node);
            return subTree;
        }
        for(int i = start; i <=end; i++) {
            List<TreeNode> leftSubTree = generateTrees(n, start, i-1);
            List<TreeNode> rightSubTree = generateTrees(n, i+1, end);

            for(TreeNode left: leftSubTree) {
                for(TreeNode right: rightSubTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }

    /*public List<TreeNode> generateTrees(int n) {
        if(n == 0) {return new ArrayList<>();}
        TreeNode node = new TreeNode(1);
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        if(n == 1) {
            return list;
        }
        list = new ArrayList<>();
        generateTrees(null, new HashSet<Integer>(), 1, n, list);
        return list;


    }

    private void generateTrees(TreeNode prev, Set<Integer> visited, int start,  int n, List<TreeNode> nodes) {

        for(int i = start; i<= n; i++) {
            if(!visited.contains(i)) {
                TreeNode node = new TreeNode(i);
                if(prev != null ) {
                    if(node.val < prev.val) {
                        prev.left = node;
                    } else {
                        prev.right = node;
                    }
                }

                if(prev == null) {
                    nodes.add(node);
                }
                visited.add(i);
                generateTrees(node, visited, 1,  n, nodes);
                visited.remove(i);
                if(prev != null) {
                    if(node.val < prev.val) {
                        prev.left = null;
                    } else {
                        prev.right = null;
                    }
                }
            }
        }

    }*/
}
