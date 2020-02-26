package serialize_deserialize_binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {return "null";}
        StringBuilder serializedTree = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if(node != null) {
                serializedTree.append(node.val).append(",");
                nodes.add(node.left);
                nodes.add(node.right);
            } else {
                serializedTree.append("null,");
            }
        }

        return serializedTree.toString().substring(0, serializedTree.length()-1);
    }



    public String serializeInorder(TreeNode root) {
        if(root == null) {return  "x,";}

        return  root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {return null;}

        String [] splitedData = data.split(",");
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(splitedData));
        TreeNode root = deserialize(nodes);
        return root;

    }

    private TreeNode deserialize(Queue<String> nodes) {
        if(nodes.isEmpty()) {
            return null;
        }

        Queue<TreeNode> nodesAdded = new LinkedList<>();
        String val = nodes.remove();
        if(val.equals("null")) {return null;}
        TreeNode root = new TreeNode(Integer.parseInt(val));

        nodesAdded.add(root);

        while(!nodes.isEmpty() && !nodesAdded.isEmpty()) {
            TreeNode node = nodesAdded.remove();
            val = nodes.remove();
            if(!val.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(val));
                nodesAdded.add(node.left);
            }
            val = nodes.remove();
            if(!val.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(val));
                nodesAdded.add(node.right);
            }
        }

        return root;

    }
}
