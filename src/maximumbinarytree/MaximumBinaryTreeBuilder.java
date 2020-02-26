package maximumbinarytree;

public class MaximumBinaryTreeBuilder {
    public static void main(String [] args) {
        int inputArray[] = {3,2,1,6,0,5};

        TreeNode maxBinaryTree = constructMaximumBinaryTreeNode(inputArray);

        System.out.println("done");
    }

    public static TreeNode constructMaximumBinaryTreeNode(int []nums) {
        TreeNode resultTree = treeNodeBuilder(nums, 0, nums.length-1);
        return resultTree;
    }

    public static TreeNode treeNodeBuilder(int [] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int maxIndex = findMax(nums, start, end);
        TreeNode rootNode = new TreeNode(nums[maxIndex]);
        rootNode.left = treeNodeBuilder(nums, start, maxIndex-1);
        rootNode.right = treeNodeBuilder(nums, maxIndex+1, end);
        return rootNode;

    }

    public static int findMax(int nums[], int start, int end) {
        int max = start;
        for(int i =start; i<=end; i++) {
            if(nums[max] <nums[i]) {
                max = i;
            }
        }
        return max;
    }
}
