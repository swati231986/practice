package concatenated_words;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> result = s.findAllConcatenatedWordsInADict(words);
        result.forEach(e -> System.out.println(e));
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        if(words.length == 0) {
            return new ArrayList<>();
        }
        Trie root  = new Trie();

        for(String word:words) {
            insertInTrie(word, root);
        }


        List<String> result = new ArrayList<>();
        for(String word:words) {
            if(isConcatenated(word, 0, root, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenated(String word, int index, Trie root, int count) {

        Trie node = root;
        for(int i=index; i<word.length();i++) {
            char c = word.charAt(i);
            if(!node.children.containsKey(c))  {
                return false;
            }
            if(node.children.containsKey(c)) {
                if(node.children.get(c).enw && i == word.length()-1) {
                    return (count >= 1);
                }
                if(node.children.get(c).enw) {
                    if(isConcatenated(word, i+1,root, count+1)) {
                        return true;
                    }
                }

                node = node.children.get(c);

            }

        }
        return false;
    }
    private void insertInTrie(String word, Trie root) {
        Trie node = root;
        Trie prev = null;
        int count = 0;
        for(char c: word.toCharArray()) {
            if(!node.children.containsKey(c)) {

                node.children.put(c, new Trie());
            }
            Trie next = node.children.get(c);
            if(count == word.length()-1) {
                next.enw = true;
            }
            count++;
            node = next;

        }

    }
}
