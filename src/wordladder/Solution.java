package wordladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String [] args) {
        List<String> wordList = Stream.of("hot","dot","dog","lot","log","cog").collect(Collectors.toList());
        //List<String> wordList = Stream.of("hot","dot","dog","lot","log").collect(Collectors.toList());
        int length = ladderLength("hit", "cog", wordList);
        System.out.println(length);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null | endWord == null || wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> words = wordList.stream().collect(Collectors.toSet());
        Queue<String> wordQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        wordQueue.add(beginWord);
        wordQueue.add(null);
        visited.add(beginWord);
        int level = 1;
        while (!wordQueue.isEmpty()) {
            String str = wordQueue.remove();
            if(str != null) {
                for(int i  =0; i<str.length() ; i++) {
                    for( char c = 'a' ; c<= 'z' ; c++) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(i,c);
                        String newString = sb.toString();
                        if(newString.equals(endWord)) {
                            return ++level;
                        }
                        if(words.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            wordQueue.add(newString);
                        }
                    }
                }
            } else {
                if(!wordQueue.isEmpty()) {wordQueue.add(null);}
                level++;
            }
        }
        return 0;
    }


    /*public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str != null) {
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);

                        // Found the end word
                        if (word.equals(endWord)) return level + 1;

                        // Put it to the queue
                        if (wordList.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;
    }*/
}
