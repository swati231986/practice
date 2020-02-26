package max_points_line;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String [] args) {
        int [][] points ={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int result = maxPoints(points);
        System.out.println(result);
    }
    public static int maxPoints(int[][] points) {
        if(points.length == 0) {return 0;}

        Map<Double, Integer> slopeFreq = new HashMap<>();
        int infinityCount = 0;
        for(int i = 0; i<points.length-1 ;i++) {
            for(int j = i+1; j<points.length; j++) {
                if(( points[i][0]-points[j][0]) == 0) {
                    infinityCount++;
                    continue;
                }
                int y = points[i][1] - points[j][1];
                int x = points[i][0]-points[j][0];
                Double slope = Double.valueOf(points[i][1] - points[j][1]) /Double.valueOf( points[i][0]-points[j][0]);
                int freq = slopeFreq.containsKey(slope) ? slopeFreq.get(slope) : 0;
                slopeFreq.put(slope, freq+1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        pq.add(infinityCount);
        for(Map.Entry <Double, Integer> entry:slopeFreq.entrySet()) {
            pq.add(entry.getValue());
        }

        return pq.poll();

    }
}
