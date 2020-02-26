package isBipartite;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        boolean result = s.isBipartite(graph);
        System.out.println(result);
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for(int i =0; i<graph.length; i++) {

            if(color[i] == -1) {
                continue;
            }
            color[i] = 0;
            Stack<Integer> stack = new Stack();

            stack.push(i);
            while(!stack.isEmpty()) {
                int node = stack.pop();

                for(int child:graph[node]) {
                    if(color[child] == -1) {
                        color[child] = color[node] ^ 1;
                        stack.push(child);
                    } else if(color[child] == color[node]){
                        return false;
                    }
                    //stack.push(child);
                }
            }
        }
        return true;
    }
}
