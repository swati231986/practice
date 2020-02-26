package findNumberOfLIS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] arr = {1,3,5,4,7};
        //int[] arr = {2,2,2,2,2};
        int[] arr = {1,2,4,3,5,4,7,2};
        int count = s.findNumberOfLIS(arr);
        System.out.println(count);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i]){
                res += cnt[i];
            }
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    /*public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) {return 0;}

        Map<Integer, List<Integer>> map = new HashMap();

        for(int i = 0; i<nums.length; i++) {
            map.put(nums[i], null);
            List<Integer> list = new ArrayList();
            for(int j =i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    list.add(nums[j]);
                }
            }

            map.put(nums[i], list);
        }
        for(int i = 0; i<nums.length;i++) {
            dfs(map, nums[i], 1);
        }

        return count;
    }*/

    int count = 0;
    int max = 0;
    private void dfs( Map<Integer, List<Integer>> graph, int node, int len) {

        if(graph.get(node) == null || graph.get(node).size() == 0) {
            if(len > max) {
                max = len;
                if(count == 0) {
                    count++;
                } else {
                    count = 1;
                }
            } else if(len == max) {
                count++;
            }
            return;
        }

        for(Integer subNode: graph.get(node)) {
            dfs(graph, subNode, len+1);
        }

    }
}
