package skyline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String [] args) {
        //int[][] buildings ={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings = {{0,2,3},{2,5,3}};
        Solution s= new Solution();
        List<List<Integer>>  list = s.getSkyline(buildings);
        list.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(" "+element));
        });
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {


        if(buildings.length == 0) {return new ArrayList();}

        List<List<Integer>> skyline = new ArrayList();

        PriorityQueue<BuildingPoint> points = new PriorityQueue<BuildingPoint>(new Comparator<BuildingPoint>() {
            @Override
            public int compare(BuildingPoint o1, BuildingPoint o2) {
                if(o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        for(int i = 0; i<buildings.length; i++) {
            BuildingPoint pointL = new BuildingPoint(buildings[i][0], buildings[i][2], 0);
            BuildingPoint pointR = new BuildingPoint(buildings[i][1], buildings[i][2], 1);
            points.add(pointL);
            points.add(pointR);
        }

        PriorityQueue<Integer> pqHeight = new PriorityQueue<Integer>((a,b) -> b-a);
        pqHeight.add(0);
        int max = 0;

        BuildingPoint prev= null;
        while(!points.isEmpty()) {
            BuildingPoint point = points.poll();
            int L = point.x;
            int height = point.y;

            if(point.startOrEnd == 0) {
                if(prev != null && L == prev.x && prev.startOrEnd == 1 && prev.y == height) {
                    pqHeight.add(height);
                    prev = point;
                    continue;
                }
                if(!points.isEmpty() && L == points.peek().x && height < points.peek().y && points.peek().startOrEnd == 0) {
                    pqHeight.add(height);
                    prev = point;
                    continue;
                }
                if(height > pqHeight.peek()) {
                    List<Integer> list = new ArrayList();
                    list.add(L);
                    list.add(height);
                    skyline.add(list);

                }
                pqHeight.add(height);
                prev = point;

            } else if(point.startOrEnd == 1){
                max = pqHeight.peek();
                pqHeight.remove(height);
                if(!points.isEmpty() && L == points.peek().x && points.peek().startOrEnd == 0) {
                    prev = point;
                    continue;
                }
                if(max != pqHeight.peek() ) {
                    List<Integer> list = new ArrayList();
                    list.add(L);
                    list.add(pqHeight.peek());
                    skyline.add(list);
                }
                prev = point;
            }
        }

        return skyline;


    }
}
