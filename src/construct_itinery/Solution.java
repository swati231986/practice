package construct_itinery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String [] args) {
        Solution s = new Solution();
        List<List<String>> tickers = Arrays.asList(
                Arrays.asList("JFK","KUL"),
                Arrays.asList("JFK","NRT"), Arrays.asList("NRT","JFK"));

        List<String> result = s.findItinerary(tickers);
        result.forEach(e -> System.out.println(e));
    }


    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null) {
            return new ArrayList();
        }

        Map<String, PriorityQueue<String>> map = new HashMap();
        List<String> result = new ArrayList();

        for(List<String> list:tickets) {
            map.putIfAbsent(list.get(0), new PriorityQueue());
            map.get(list.get(0)).add(list.get(1));
        }

        dfs("JFK", map, result);
        return result;

    }

    private void dfs(String departure, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> pq = map.get(departure);


        while(pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, result);
        }

        result.add(0,departure);
    }

}
