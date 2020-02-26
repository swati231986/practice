package word_dictionary;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        insertIntoTrie(word);
    }

    private void insertIntoTrie(String word) {
        if(word == null || word.length() == 0) {return;}
        int c = 0;
        TrieNode trie = root;
        while(c < word.length()) {
            if(trie.getChildren() != null) {
                if(trie.getChildren().containsKey(word.charAt(c))) {
                    trie = trie.getChildren().get(word.charAt(c));
                } else {
                    TrieNode node = new TrieNode(null, false);
                    trie.getChildren().put(word.charAt(c), node);
                    trie = node;
                }
            } else {
                Map<Character, TrieNode> map = new HashMap<>();
                TrieNode node = new TrieNode(null, false);
                map.put(word.charAt(c), node);
                trie.setChildren(map);
                trie = node;
            }
            c++;
        }
        trie.setEndOfWord(true);
    }

    private boolean searchTrie(String word, TrieNode root) {
        if(word == null) {return false;}
        int c = 0;
        TrieNode trie = root;
        while(c < word.length()) {
            if(trie.getChildren() == null || (word.charAt(c) != '.' && !trie.getChildren().containsKey(word.charAt(c)))) {return false;}
            if(word.charAt(c) == '.') {
                for(Map.Entry<Character, TrieNode> child: trie.getChildren().entrySet()) {
                    String subStr = word.substring(c+1,word.length());
                    if(searchTrie(subStr, child.getValue())) {
                        return true;
                    }
                }
                return false;
            } else {
                trie = trie.getChildren().get(word.charAt(c));
            }
            c++;
        }
        return trie.isEndOfWord();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTrie(word, root);
    }
}
