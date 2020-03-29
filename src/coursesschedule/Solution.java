package coursesschedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) {
            if(numCourses == 0) {
                return new int[0];
            }
            int arr[] = new int[numCourses];
            for(int i = 0; i<numCourses; i++) {
                arr[i] = i;
            }
            return arr;
        }

        Map<Integer, Set<Integer>> graph =  new HashMap();

        for(int[] course:prerequisites) {
            if(!graph.containsKey(course[0])) {
                graph.put(course[0], new HashSet());
            }
            graph.get(course[0]).add(course[1]);
        }
        Set<Integer> courses = new LinkedHashSet<>();

        for(Map.Entry<Integer, Set<Integer>> node:graph.entrySet()) {
            if(courses.size() == numCourses) {
                break;
            }
            dfs(graph, node.getKey(), courses);
            if(!courses.contains(node.getKey())) {
                boolean allPrereqsMet = true;
                for(Integer prereqs: graph.get(node.getKey())) {
                    if(!courses.contains(prereqs)) {
                        allPrereqsMet = false;
                    }
                }
                if(allPrereqsMet) {
                    courses.add(node.getKey());
                }
            }

        }


        if(courses.size() == numCourses) {
            List<Integer> list =  courses.stream().collect(Collectors.toList());
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }

    private void dfs(Map<Integer, Set<Integer>> graph, Integer node, Set<Integer> courses ) {

        if(courses.contains(node)) {
            return;
        }
        if(!graph.containsKey(node)) {
            courses.add(node);
            return;
        }
        for(Integer prereqs: graph.get(node)) {
            dfs(graph, prereqs, courses);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{0,1}};
        int[] result = s.findOrder(2, arr);
        for(int i:result) System.out.println(i);
    }
}
