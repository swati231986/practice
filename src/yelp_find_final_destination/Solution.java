package yelp_find_final_destination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    private static Map<String, Queue<String>> nodes = new HashMap<>();
    private static String destination;
    public static void main(String [] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point("A", "B"));
        points.add(new Point("B", "C"));
        points.add(new Point("C", "D"));
        points.add(new Point("D", "B"));
        points.add(new Point("B", "E"));
        points.add(new Point("D", "E"));
        points.add(new Point("E", "F"));
        points.add(new Point("F", "G"));
        points.add(new Point("G", "H"));
        points.add(new Point("H", "I"));

        Collections.shuffle(points);

        String destination = getDestination(points);
        System.out.println(destination);
    }

    public static String getDestination(List<Point> points) {
        if(points == null || points.size() == 0) {
            return null;
        }
        loadDate(points);
        getDestination("A");
        return destination;
    }

    private static void getDestination(String node) {
        if(node == null) {
            return;
        }
        if(!nodes.containsKey(node)) {
            destination = node;
            return;
        }
        while (!nodes.get(node).isEmpty()) {
            String dest = nodes.get(node).poll();
             getDestination(dest);
        }

    }

    private static void loadDate(List<Point> points) {
        for(Point point: points) {
            if(nodes.containsKey(point.getSource())) {
                nodes.get(point.getSource()).add(point.getDestination());
            } else {
                Queue<String> queue = new LinkedList<>();
                queue.add(point.getDestination());
                nodes.put(point.getSource(), queue);
            }
        }
    }
}
