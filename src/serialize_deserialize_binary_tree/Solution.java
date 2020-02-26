package serialize_deserialize_binary_tree;

public class Solution {
    public static void main(String []args) {
        Codec codec = new Codec();


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedTree = codec.serialize(root);
        System.out.println(serializedTree);

        TreeNode treeDeserialized = codec.deserialize(serializedTree);

        System.out.println("");

    }
}
