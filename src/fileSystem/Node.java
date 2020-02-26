package fileSystem;

import java.util.Map;
import java.util.Set;

public class Node {

    public Node(){

    }

    private String name;

    public Node(String name, Map<String, Node> children, boolean isFile, String content) {
        this.name = name;
        this.children = children;
        this.isFile = isFile;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Node> children) {
        this.children = children;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Map<String, Node> children;
    private boolean isFile;
    private String content;


}
