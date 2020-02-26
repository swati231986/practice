package merge_intervals;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String []args) {
        //int [] [] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int [] [] intervals = {{1,3},{8,10},{15,18},{2,6}};
        int [] [] intervals = {{1,3},{6,10},{15,18},{3,6}};
        int [][] mergedArray = merge(intervals);

        Arrays.stream(mergedArray).forEach(e -> {
            System.out.println();
            Arrays.stream(e).forEach(x -> System.out.print(x+" "));
        });
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        if(intervals.length <=0) {return  resultList.stream().toArray(int[][]::new);}


        Arrays.sort(intervals, Comparator.<int[]>comparingInt(x -> x[0]).thenComparing(y -> y[0]));

        int min = intervals[0][0];
        int max = intervals[0][1];

        int count = 0;

        for(int i =1; i< intervals.length ; i++) {
            if(intervals[i][0] <= max) {
                // within the range
                max = Math.max(max, intervals[i][1]);
            } else {
                int arr[] = {min, max};
                resultList.add(count, arr);
                count++;

                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        int arr[] = {min, max};
        resultList.add(count, arr);

        int [][] result = resultList.stream().toArray(int[][]::new);


        return result;
    }
}
