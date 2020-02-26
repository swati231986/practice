package palindrome_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    public int wordEnding = -1; // We'll use -1 to mean there's no word ending here.
    public Map<Character, TrieNode> next = new HashMap<>();
    public List<Integer> palindromePrefixRemaining = new ArrayList<>();
}
