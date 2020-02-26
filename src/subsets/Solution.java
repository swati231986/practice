package subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int [] nums = {1,2,3};
        List<List<Integer>> allSubsets = s.subsets(nums);
        allSubsets.forEach(e-> {
            System.out.println();
            e.forEach( element -> System.out.print(element+ " "));
        });
    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) {return new ArrayList();}

        List<List<Integer>> allSubsets = new ArrayList();

        subsets(nums, new ArrayList<>(), allSubsets, 0);

        return allSubsets;
    }
    private void subsets(int [] nums, List<Integer> list, List<List<Integer>> allSubsets, int start) {

        allSubsets.add(new ArrayList(list));
        for(int i = start ; i< nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, list, allSubsets, i+1);
            list.remove(list.size()-1);
        }
    }
}
