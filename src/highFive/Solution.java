package highFive;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int [][] studentsAvgScore = s.highFive(items);
        for (int i=0; i<studentsAvgScore.length;i++ ){
            System.out.println(studentsAvgScore[i][0] + " "+studentsAvgScore[i][1]);
        }
    }

    public int[][] highFive(int[][] items) {
        if(items.length == 0) {return new int[0][0];}

        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        PriorityQueue <Integer>pqStudentId = new PriorityQueue<Integer>((a,b) -> a-b);

        for(int i =0; i< items.length; i++) {
            if(!pqStudentId.contains(items[i][0])) {
                pqStudentId.add(items[i][0]);
            }

            if(map.containsKey(items[i][0])) {
                map.get(items[i][0]).add(items[i][1]);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
                pq.add(items[i][1]);
                map.put(items[i][0], pq);
            }
        }

        int[][] result = new int[pqStudentId.size()][2];

        int index = 0;
        while(!pqStudentId.isEmpty()) {
            int studentId = pqStudentId.remove();
            int average = 0;
            int i = 0;
            for(;i<5 && map.get(studentId).size() > 0; i++) {
                average = average + map.get(studentId).remove();
            }
            if(i >0) {
                result[index][0] = studentId;
                result[index][1] = average/(i);
                index++;
            }

        }

        return result;
    }
}
