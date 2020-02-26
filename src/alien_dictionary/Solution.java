package alien_dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
       // String[] words = {"wrt","wrf","er","ett","rftt"};
        //String[] words = {"aac","aabb","aaba"};
        String[] words = {"za","zb","ca","cb"};

        Solution s = new Solution();
        String result = s.alienOrder(words);
        System.out.println(result);
    }

    private final int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

    /*public String alienOrder(String[] words) {
        if(words.length == 0) {return null;}

        Map<Character, Set<Character>> map = new HashMap();
        Map<Character, Integer> degree = new HashMap();

        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                char c = words[i].charAt(j);
                degree.put(c, 0);
            }
        }

        for(int i =0; i< words.length-1; i++) {

            String curr = words[i];
            String next = words[i+1];

            int len = Math.min(curr.length(), next.length());

            for(int j =0; j<len; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if(c1 != c2) {
                    Set<Character> set = new HashSet();

                    if(map.containsKey(c1)) {
                        set = map.get(c1);
                        if(!set.contains(c2)) {
                            set.add(c2);
                            degree.put(c2, degree.get(c2) + 1);
                        }
                    } else {
                        set.add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    map.put(c1, set);
                }
            }
        }

        Queue<Character> queue = new LinkedList();

        for(Map.Entry<Character, Integer> entry:degree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if(map.containsKey(c)) {
                Set<Character> set = map.get(c);
                for(Character s:set) {
                    degree.put(s, degree.get(s) -1);
                    if(degree.get(s) == 0) {
                        queue.add(s);
                    }
                }
            }

        }

        return sb.toString();

    }*/
   /* public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }

        if(result.length()!=degree.size()) return "";
        return result;
    }*/

    /*public String alienOrder(String[] words) {
        if(words.length == 0) {return null;}

        List<String> list = Arrays.asList(words);
        dfs(list, 0, new HashMap(), new HashSet());
        return result.toString();
    }
    StringBuilder result = new StringBuilder();
    private void dfs(List<String> words, int index, Map<Character, List<String>> wordMap, Set<Character> charactersAdded) {
            StringBuilder sb = new StringBuilder();

        for(int i = 0; i<words.size(); i++) {
            if(index >= words.get(i).length()) {continue;}
            char c = words.get(i).charAt(index);
            if(!charactersAdded.contains(c)) {
                sb.append(c);
                charactersAdded.add(c);
            }
            if(wordMap.containsKey(c)) {
                if(i > 0 && words.get(i-1).charAt(index) != c) {
                    result = new StringBuilder();
                    return;
                }
                wordMap.get(c).add(words.get(i));
            } else {
                List<String> list = new ArrayList();
                list.add(words.get(i));
                wordMap.put(c, list);
            }
        }
        result.append(sb);
        for(int i =0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            dfs(wordMap.get(c), index+1, new HashMap(), charactersAdded);
        }
    }*/
}
