package abstractmap;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        int[][] points = {{-5,4},{-6,-5},{4,6}};
        Solution s = new Solution();

        int closest [][] = s.kClosest(points, 2);
        for(int[] point: closest) {
            System.out.println(point[0]+" "+point[1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if(points.length == 0 || K ==0) {
            int arr[][] = new int[0][0];
            return arr;
        }


        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());

        for(int i = 0; i<points.length; i++) {
            int  x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            Map.Entry<Integer, Integer> indexDistMap =  new AbstractMap.SimpleEntry<Integer, Integer>(i, dist);
            pq.add(indexDistMap);
        }

        int[][] result = new int[K][2];
        int index = 0;
        while(K > 0) {
            Map.Entry<Integer, Integer> indexDistMap = pq.remove();
            result[index][0] = points[indexDistMap.getKey()][0];
            result[index][1] = points[indexDistMap.getKey()][1];
            index++;
            K--;
        }

        return result;
    }
}
