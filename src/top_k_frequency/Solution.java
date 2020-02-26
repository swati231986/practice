package top_k_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String [] args) {
        int[] nums = {1,1,1,2,2,3,3,4,4,4,4,4,5,5,7,7,7,7,7,7, 8,8,8,8,8,8,9,9,9,9,9,9,6,6,6,6,6,6};
        List<Integer> topkElements = topKFrequent(nums, 3);
        topkElements.forEach(e -> System.out.println(e));
    }

    /*public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }*/


    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k==0) {return new ArrayList();}

        Map<Integer, Integer> intFrequency = new HashMap();

        for( int i =0; i<nums.length; i++) {
            if(intFrequency.get(nums[i]) == null) {
                intFrequency.put(nums[i], 1);
            } else {
                int count = intFrequency.get(nums[i]);
                intFrequency.put(nums[i],++count);
            }
        }


        List<Integer> result = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b)-> (b.getValue()-a.getValue()));



        for(Map.Entry entry: intFrequency.entrySet()) {
            priorityQueue.add(entry);
        }

        for(int i =0; i<k && !priorityQueue.isEmpty();i++) {
            result.add(priorityQueue.poll().getKey());
        }

        return result;
    }

}
