package build_inorder_postorder;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Solution s = new Solution();
        TreeNode root = s.buildTree(inorder, postorder);
        System.out.println(root);
    }


    Map<Integer, Integer> inorderMap = new HashMap();


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        return root;

         /*if(inorder.length == 0 && postorder.length == 0) {return null;}
        int rootVal = postorder[postorder.length - 1] ;
        TreeNode root = new TreeNode(rootVal);
        int index = findIndex(inorder, rootVal);
        if(index == -1) {return null;}
        int newInorderLeft[] = new int[index - 0];
        System.arraycopy(inorder, 0, newInorderLeft, 0, newInorderLeft.length);

        int newInorderRight[] = new int[inorder.length - index - 1];
        System.arraycopy(inorder, index+1, newInorderRight, 0, newInorderRight.length);

        int lenLeft = newInorderLeft.length;
        int newPostorderRight [] = new int[postorder.length - lenLeft - 1];
        System.arraycopy(postorder, lenLeft, newPostorderRight, 0, newPostorderRight.length);

        int newPostorderLeft[] = new int[lenLeft];
        System.arraycopy(postorder, 0, newPostorderLeft, 0, newPostorderLeft.length);

        root.right = buildTree(newInorderRight, newPostorderRight);
        root.left = buildTree(newInorderLeft, newPostorderLeft);

        return root;*/

    }

    private TreeNode buildTree(int []inorder, int[]postorder, int startInorder, int endInorder, int startPostorder, int endPostorder) {
        if(startInorder > endInorder || startPostorder>endPostorder || startInorder <0 || startPostorder <0 || endInorder >= inorder.length || endPostorder >= postorder.length ) {
            return null;
        }

        int rootVal = postorder[endPostorder];
        TreeNode root = new TreeNode(rootVal);
        int indexInorder = inorderMap.get(rootVal);

        root.right = buildTree(inorder, postorder, indexInorder+1, endInorder, endPostorder- (endInorder- indexInorder), endPostorder-1);

        root.left = buildTree(inorder, postorder, startInorder, indexInorder-1, startPostorder, startPostorder + (indexInorder -startInorder ) -1);
        return root;

    }
   /* public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 && postorder.length == 0) {return null;}
        int rootVal = postorder[postorder.length - 1] ;
        TreeNode root = new TreeNode(rootVal);
        int index = findIndex(inorder, rootVal);
        if(index == -1) {return null;}
        int newInorderLeft[] = new int[index - 0];
        System.arraycopy(inorder, 0, newInorderLeft, 0, newInorderLeft.length);

        int newInorderRight[] = new int[inorder.length - index - 1];
        System.arraycopy(inorder, index+1, newInorderRight, 0, newInorderRight.length);

        int lenLeft = newInorderLeft.length;
        int newPostorderRight [] = new int[postorder.length - lenLeft - 1];
        System.arraycopy(postorder, lenLeft, newPostorderRight, 0, newPostorderRight.length);

        int newPostorderLeft[] = new int[lenLeft];
        System.arraycopy(postorder, 0, newPostorderLeft, 0, newPostorderLeft.length);

        root.right = buildTree(newInorderRight, newPostorderRight);
        root.left = buildTree(newInorderLeft, newPostorderLeft);

        return root;

    }

    private int findIndex(int[] inorder, int n) {
        for (int i = 0; i<inorder.length; i++) {
            if(inorder[i] == n) {return i;}
        }
        return -1;
    }*/


}
