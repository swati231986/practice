package word_dictionary;

import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEndOfWord;


    public TrieNode(){}
    public TrieNode(Map<Character, TrieNode> children, boolean isEndOfWord) {
        this.children = children;
        this.isEndOfWord = isEndOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
