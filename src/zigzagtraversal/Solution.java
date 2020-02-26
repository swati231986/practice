package zigzagtraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/



        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        result.forEach(list -> {
            System.out.println();
            list.forEach(e -> System.out.print(e + " "));
        });
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {return new ArrayList<>();}

        int level =0;
        List<List<Integer>> zigzagTraversal = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                List<Integer> list = new ArrayList<>();
                list.add(node.val);

                if(zigzagTraversal.size() > level) {
                    List<Integer> existingList = zigzagTraversal.get(level);
                    List<Integer> finalList = Stream.concat(existingList.stream(), list.stream()).collect(Collectors.toList());
                    zigzagTraversal.remove(level);
                    zigzagTraversal.add(level, finalList);
                } else {
                    zigzagTraversal.add(level, list);
                }

                if(node.left != null) {stack2.push(node.left);}
                if(node.right != null) {stack2.push(node.right);}
            }
            level++;
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                if(zigzagTraversal.size() > level) {
                    List<Integer> existingList = zigzagTraversal.get(level);
                    List<Integer> finalList = Stream.concat(existingList.stream(), list.stream()).collect(Collectors.toList());
                    zigzagTraversal.remove(level);
                    zigzagTraversal.add(level, finalList);
                } else {
                    zigzagTraversal.add(level, list);
                }
                if(node.right != null) {stack1.push(node.right);}
                if(node.left != null) {stack1.push(node.left);}
            }
            level++;
        }
        return zigzagTraversal;
    }


    // this solution didn't work. commenting it.
    /*public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList();

        List<List<Integer>> zigzagTraversal = new ArrayList();
        if(root == null) {return  zigzagTraversal;}
        int level = 1;
        boolean isReverse = true;
        nodeQueue.add(root);
        List <Integer> rootElement = new ArrayList();
        rootElement.add(0,root.val);
        zigzagTraversal.add(0,rootElement);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if(node == null) {
                level++;
                isReverse = !isReverse;
                continue;
            }
            if(nodeQueue.isEmpty()) {
                nodeQueue.add(null);
            }
            Stack<Integer> list = new Stack<>();
            if( isReverse) {
                if(node.right != null) {list.push(node.right.val);}
                if(node.left != null) {list.push(node.left.val);}
                if(node.right != null) {nodeQueue.add(node.right);}
                if(node.left != null) {nodeQueue.add(node.left);}
            } else {
                if(node.left != null) {list.push(node.left.val);}
                if(node.right != null) {list.push(node.right.val);}
                if(node.left != null) {nodeQueue.add(node.left);}
                if(node.right != null) {nodeQueue.add(node.right);}
            }

            if(list.size()>0) {
                if(level < zigzagTraversal.size()) {
                    List<Integer> existingList = zigzagTraversal.get(level);
                    List<Integer> listToAdd = Stream.concat(list.stream(), existingList.stream()).collect(Collectors.toList());
                    zigzagTraversal.remove(level);
                    zigzagTraversal.add(level,listToAdd);
                } else {
                    zigzagTraversal.add(level,list);
                }

            }

        }
        return zigzagTraversal;
    } */
}
