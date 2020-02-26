package findpathfromsourcetotarget;

import java.util.ArrayList;
import java.util.List;

public class SourceToTarget {
    public static void main(String [] arg) {
        //int [][] graph = {{1,2},{3},{3},null};
        int[][] graph = {{2},{0,3,4},{},{2,4},{}};
        List<List<Integer>>ans = allPathsSourceTarget(graph);
        for (List<Integer> list : ans) {
            System.out.println();
            for (Integer myint:list) {
                System.out.print(myint + " ");
            }
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public static List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList()   ;
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
