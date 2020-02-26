package greater_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertBSTToGreater {

    static List<Integer> nodeList = new ArrayList();
    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        Map<Integer, Integer> mapSum = new HashMap();
        inOrderTraversal(root);
        for(int i =0; i<nodeList.size();i++) {
            if(i == 0) {
                mapSum.put(nodeList.get(0), sum);
                continue;
            }
            mapSum.put(nodeList.get(i), mapSum.get(nodeList.get(i-1))-nodeList.get(i-1));
        }
        return createTree(root, mapSum);
    }

    public static void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        nodeList.add(root.val);
        sum = sum + root.val;
        inOrderTraversal(root.right);
    }

    public static TreeNode createTree(TreeNode rootOriginal, Map<Integer, Integer>  mapSum) throws NullPointerException {
        if(rootOriginal == null) {
            return null;
        }
        int greaterNum = mapSum.get(rootOriginal.val);
        TreeNode node = new TreeNode(greaterNum);
        node.left = createTree(rootOriginal.left, mapSum);
        node.right = createTree(rootOriginal.right, mapSum);
        return node;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        try {
            TreeNode greaterTree  = convertBST(root);
            System.out.println(greaterTree);
        } catch (NullPointerException e) {}

    }
}
