package count_components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //int [][] edges = {{0,1}, {2,3}, {1,2}};
        int[][] edges = {};
        int count = s.countComponents(1,edges);
        System.out.println(count);
    }

    public int countComponents(int n, int[][] edges) {
        if(n == 0) {return 0;}

        if(n == 1) {return 1;}

        Map<Integer, List<Integer>> graph = new HashMap();

        for(int i = 0; i<edges.length; i++) {

                if(graph.containsKey(edges[i][0])) {
                    List<Integer> nodes = graph.get(edges[i][0]);
                    nodes.add(edges[i][1]);
                    graph.put(edges[i][0],nodes);

                } else {
                    List<Integer> nodes = new ArrayList();
                    nodes.add(edges[i][1]);
                    graph.put(edges[i][0], nodes);
                }

        }
        int count = 0;
        Set<Integer> visited = new HashSet();
        for(Map.Entry<Integer, List<Integer>> entrySet:graph.entrySet()) {
            if(!visited.contains(entrySet.getKey())) {
                count++;
                traverseGraph(graph, visited, entrySet.getKey());
            }
        }
        if(visited.size() < n) {
            count = count + n - visited.size();
        }

        return count;
    }

    private void traverseGraph(Map<Integer, List<Integer>> graph, Set<Integer> visited, Integer node) {
        if(graph == null ||node == null) {return;}

        if(!visited.contains(node)) {
            visited.add(node);
            if(!graph.containsKey(node)) {
                return;
            }
            for(Integer destination: graph.get(node)) {
                traverseGraph(graph, visited, destination);
            }
        }

    }
}
