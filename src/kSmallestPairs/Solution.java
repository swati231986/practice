package kSmallestPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        Solution s = new Solution();
        List<List<Integer>> result = s.kSmallestPairs(nums1, nums2, 3);
        result.forEach(e-> e.forEach(element -> System.out.println(element)));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if(nums1.length <=0 || nums2.length <= 0 || k <= 0) {
            return new ArrayList();
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a , b) -> a[0]+a[1] - b[0]-b[1]);

        List<List<Integer>> result =  new ArrayList();

        for(int j =0; j<nums2.length; j++) {
            int arr[] = {nums1[0], nums2[j]};
            pq.add(arr);
        }

        int len1  =nums1.length; int len2 = nums2.length;
        int count =1;
        for(int i = 1, j= 0; i<nums1.length && j<nums2.length && count <= Math.min(len1*len2, k);  count++) {
            if(!pq.isEmpty()) {
                int []arr = pq.poll();
                List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
                result.add(list);
            }

            int [] arr = {nums1[i], nums2[j]};
            pq.add(arr);

            j++;
            if(j == nums2.length) {j = 0; i++;}
        }
        if(count <= k && !pq.isEmpty()) {
            int []arr = pq.poll();
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            result.add(list);
            count++;
        }

        return result;
    }
}
