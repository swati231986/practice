package fileSystem;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileSystem {

    private Node head = null;

    public FileSystem() {
        head = new Node("/", null, false, null);
    }

    public List<String> ls(String path) {
        Node lastNode = getLastNode(path);
        if(!lastNode.isFile()) {
            if( lastNode.getChildren() == null ||  lastNode.getChildren().isEmpty()) {
                return new ArrayList<>();
            }
            List<String> files = lastNode.getChildren().keySet().stream().collect(Collectors.toList());
            Collections.sort(files);
            return files;
        }
        Node secondLast = getSecondLastNode(path);
        List<String> files = new ArrayList<>();
        Map<String, Node> children = secondLast.getChildren();
        for(Map.Entry<String, Node> child:children.entrySet()) {
            if(child.getValue().isFile() && child.getValue().getName().equals(lastNode.getName())) {
                files.add(child.getKey());
            }
        }

        Collections.sort(files);
        return files;

    }

    private Node getSecondLastNode(String path) {
        String [] dirPath = path.split("/");
        Node prev = head;
        for(int i = 0;i <dirPath.length-1; i++ ) {
            if(dirPath[i].isEmpty()) {
                continue;
            }
            if(prev.getChildren() != null && prev.getChildren().containsKey(dirPath[i])) {
                prev = prev.getChildren().get(dirPath[i]);
            } else {
                return null;
            }
        }
        return prev;
    }

    public void mkdir(String path) {
        createNodes(path);
    }

    private Node createNodes(String path) {
        String [] dirPath = path.split("/");
        Node prev = head;
        for(String dir:dirPath) {
            if(dir.isEmpty()) {
                continue;
            }
            if(prev.getChildren() != null && prev.getChildren().containsKey(dir)) {
                prev = prev.getChildren().get(dir);
            } else {
                Node newNode = new Node(dir, null, false, null);
                if(prev.getChildren() == null) {
                    prev.setChildren(new HashMap<>());
                }
                prev.getChildren().put(dir, newNode);
                prev = newNode;
            }
        }
        return prev;
    }

    private Node getLastNode(String path) {
        String [] dirPath = path.split("/");
        Node prev = head;
        for(String dir:dirPath) {
            if(dir.isEmpty()) {
                continue;
            }
            if(prev.getChildren() != null && prev.getChildren().containsKey(dir)) {
                prev = prev.getChildren().get(dir);
            } else {
               return null;
            }
        }
        return prev;
    }

    public void addContentToFile(String filePath, String content) {

        Node prev = createNodes(filePath);

        if(!prev.isFile()) {
            prev.setFile(true);
        }
        StringBuilder contentToAdd = new StringBuilder();
        if(prev.getContent() != null ) {
            contentToAdd.append(prev.getContent());
        }
        contentToAdd.append(content);
        prev.setContent(contentToAdd.toString());
    }

    public String readContentFromFile(String filePath) {
        Node lastNode = getLastNode(filePath);
        if(lastNode == null) {return new String();}

        return lastNode.getContent();
    }

}
