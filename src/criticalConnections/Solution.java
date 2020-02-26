package criticalConnections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[]args) {
        Solution s = new Solution();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0); list.add(1);
        connections.add(list);

        list = new ArrayList<>();
        list.add(1); list.add(2);
        connections.add(list);

        list = new ArrayList<>();
        list.add(2); list.add(0);
        connections.add(list);

        list = new ArrayList<>();
        list.add(1); list.add(3);
        connections.add(list);

        List<List<Integer>> criticalConnections = s.criticalConnections(4,connections);
        criticalConnections.forEach(l -> {
            System.out.println();
            l.forEach(e -> System.out.print(e+" "));
        });
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(n == 0  || connections == null || connections.size() == 0 ) {return null;}
        List<Integer> singleNodes = new ArrayList();
        Map<Integer, Integer> freq = new HashMap();

        Map<Integer, Integer> index = new HashMap();
        int count = 0;
        for(List<Integer> connection:connections) {
            if(freq.containsKey(connection.get(0))) {
                freq.put(connection.get(0), freq.get(connection.get(0))+1);
            } else {
                freq.put(connection.get(0),1);

            }
            index.put(connection.get(0), count);

            if(freq.containsKey(connection.get(1))) {
                freq.put(connection.get(1), freq.get(connection.get(1))+1);
            } else {
                freq.put(connection.get(1),1);

            }
            index.put(connection.get(1), count);
            count++;
        }


        for(Map.Entry<Integer, Integer> entry:freq.entrySet()) {
            if(entry.getValue() == 1) {
                singleNodes.add(index.get(entry.getKey()));
            }
        }

        if(singleNodes.size() == 0) {
            return null;
        }

        List<List<Integer>> criticalConnections = new ArrayList();

        for(int singleNode:singleNodes) {
            criticalConnections.add(connections.get(singleNode));
        }

        return criticalConnections;

    }
}
