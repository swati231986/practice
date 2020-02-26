package create_tree_preorder_traversal;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        TreeNode root = s.recoverFromPreorder("1-2--3--4-5--6--7");
        //TreeNode root = s.recoverFromPreorder("1-2--3---14-5--6---7");
        System.out.println(root.val);
    }
    TreeNode root  = null;

    public TreeNode recoverFromPreorder(String s) {
        if(s == null || s == "") {return null;}

        Stack<TreeNode> stack = new Stack();
        int level = 0;
        for(int i = 0; i<s.length(); ) {
            level = 0;
            while(i<s.length() && s.charAt(i) == '-') {level++; i++;}

            int val = 0;
            while(i<s.length() && Character.isDigit(s.charAt(i))) {
                val = 10*val + (s.charAt(i) - '0');
                i++;
            }
            TreeNode node  = new TreeNode(val);

            while(stack.size() > level) {stack.pop();}
            if(!stack.isEmpty()) {
                if(stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }

        TreeNode root = null;
        while(!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;

        /*recoverFromPreorder(s, 1);
        return root;*/
    }

   /* public TreeNode recoverFromPreorder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }*/

    /*public TreeNode recoverFromPreorder(String s) {
        if(s == null || s == "") {return null;}

        recoverFromPreorder(s, 1);
        return root;
    }*/

    private TreeNode recoverFromPreorder(String s, int level) {
        if(s == null || s == "") {return null;}
        int numLen = 0;
        String c = "";
        while(numLen<s.length() && Character.isDigit(s.charAt(numLen))) {
            c = c + s.charAt(numLen);
            numLen++;
        }


        TreeNode node = new TreeNode(Integer.parseInt(c));
        if(level == 1) {
            root = node;
        }
        if(numLen+level< s.length()) {
            String str = s.substring(numLen+level);
            int index = findSibling( str, level);
            String leftSubstring = null;
            String rightSubstring  =null;
            if(index == -1 ) {
                leftSubstring = s.substring(numLen+level);
            } else {
                leftSubstring = s.substring(numLen+level, index+level+numLen);
                rightSubstring = s.substring(index+level+numLen);
            }
            node.left = recoverFromPreorder(leftSubstring, level+1);
            node.right = recoverFromPreorder(rightSubstring, level+1);
        }

        return node;
    }
    /*private TreeNode recoverFromPreorder(String s, int level) {
        if(s == null || s == "") {return null;}
        char c = s.charAt(0);
        TreeNode node = new TreeNode(Character.getNumericValue(c));
        if(level == 1) {
            root = node;
        }
        if(1+level< s.length()) {
            String str = s.substring(1+level);
            int index = findSibling( str, level);
            String leftSubstring = null;
            String rightSubstring  =null;
            if(index == -1 ) {
                leftSubstring = s.substring(1+level);
            } else {
                leftSubstring = s.substring(1+level, index+level+1);
                rightSubstring = s.substring(index+level+1);
            }
            node.left = recoverFromPreorder(leftSubstring, level+1);
            node.right = recoverFromPreorder(rightSubstring, level+1);
        }

        return node;
    }*/

    private int findSibling(String s, int level) {
        int index = 0;
        int num = 0;
        for(int i = 0; i<s.length();i++) {
            if(s.charAt(i) == '-') {
                num++;
            } else {
                if(num == level) {
                    return i;
                }
                num = 0;
            }
        }
        return -1;
    }
}
