package word_ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {


        List<String> wordList = Stream.of("hot","dot","dog","lot","log","cog").collect(Collectors.toList());
        String start = "hit";
        String end = "cog";

        Solution s = new Solution();
        List<List<String>>  result = s.findLadders(start, end , wordList);
        result.forEach(e-> {
            System.out.println(e);
            e.forEach(element -> System.out.print(" "+element));
        });
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord == "" || endWord == null || endWord == "" || wordList == null || wordList.size() == 0) {return new ArrayList();}

        Map<String, List<String>> nodeNeighbors = new HashMap();
        Map<String, Integer> distance = new HashMap();

        List<List<String>> shortestPath = new ArrayList();
        nodeNeighbors.put(beginWord, new ArrayList());
        Set<String> words = new HashSet();

        for(String word: wordList) {
            nodeNeighbors.put(word, new ArrayList());
            words.add(word);
        }
        words.add(beginWord);
        distance.put(beginWord, 0);

        populateNeighborAndDistance( beginWord, endWord, wordList, nodeNeighbors, distance, words);

        findShortestPath(beginWord, endWord,nodeNeighbors, distance, shortestPath, new ArrayList());

        return shortestPath;
    }

    private void populateNeighborAndDistance(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, Set<String> words) {


        Queue<String> queue = new LinkedList();
        queue.add(beginWord);

        while(!queue.isEmpty()) {
            boolean endFound = false;
            int size = queue.size();
            for(int i =0; i<size; i++) {
                String currNode = queue.poll();

                List<String> allNeighbors = findNeighBors(currNode, words);
                int currentDistance = distance.get(currNode);

                for(String neighbor: allNeighbors) {
                    nodeNeighbors.get(currNode).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currentDistance+1);
                        if(neighbor.equals(endWord)) {
                            endFound = true;
                        } else {
                            queue.add(neighbor);
                        }
                    }

                }
            }

            if(endFound) {break;}
        }
    }

    private List<String> findNeighBors(String currentNode, Set<String> words) {
        List<String> neighbors = new ArrayList();

        char[] chs = currentNode.toCharArray();

        for( char c = 'a' ; c<='z'; c++) {
            for(int i = 0; i<chs.length; i++) {
                if(chs[i] == c) {continue;}

                char oldChar = chs[i];
                chs[i] = c;
                if(words.contains(String.copyValueOf(chs))) {
                    neighbors.add(String.copyValueOf(chs));
                }
                chs[i] = oldChar;
            }
        }
        return neighbors;
    }

    private void findShortestPath(String curr, String endWord, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<List<String>> shortestPath , List<String> list) {

        list.add(curr);

        if(curr.equals(endWord)) {
            shortestPath.add(new ArrayList(list));

        }

        for(String neighbor: nodeNeighbors.get(curr)) {
            if(distance.get(neighbor) == distance.get(curr) + 1) {
                findShortestPath(neighbor, endWord, nodeNeighbors, distance, shortestPath, list);
            }
        }
        list.remove(list.size()-1);

    }

   /* public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }*/
}
