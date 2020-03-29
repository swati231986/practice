package mycalendartwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MyCalendarTwo {
    /*List<List<Integer>> schedule = new ArrayList();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {


        List<Integer> list = new ArrayList();
        list.add(start); list.add(end);
        List<List<Integer>> tempSchedule = new ArrayList(schedule);
        tempSchedule.add(list);
        Collections.sort(tempSchedule, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });

        if(isTripleBooked(tempSchedule)) {
            return false;
        }

        schedule.add(list);

        return true;
    }

    private boolean isTripleBooked(List<List<Integer>> schedule ) {
        int count =1;
        PriorityQueue<Integer> pqEndTime = new PriorityQueue<>((a, b) -> b-a);

        for(List<Integer> entry:schedule) {
            if(!pqEndTime.isEmpty()) {
                int end = pqEndTime.peek();
                if(end > entry.get(0)) {

                    count++;
                } else {
                    if( count==3) {
                        return true;
                    }
                    count = 1;
                }
            }
            pqEndTime.add(entry.get(1));
        }
        return count==3 ? true:false;

    }*/

    private TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
