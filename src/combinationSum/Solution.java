package combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();

        int [] candidate = {2,3,6,7};
        List<List<Integer>> finalList = s.combinationSum(candidate,7);

        finalList.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element + " "));
        });
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) {return new ArrayList();}

        List<List<Integer>> finalList = new ArrayList();
        combinationSum(candidates, target, new ArrayList(), finalList,0);
        return finalList;
    }

    private void combinationSum(int[] candidates, int numLeft, List<Integer> list, List<List<Integer>> combinations, int start) {
        if(numLeft == 0) {
            combinations.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }

        for(int i = start ; i < candidates.length; i++) {
            if(numLeft - candidates[i] >= 0) {
                list.add(candidates[i]);
                combinationSum(candidates, numLeft - candidates[i], list, combinations, i);
                if(!list.isEmpty()) {
                    list.remove(list.size()-1);
                }
            }

        }
        if(!list.isEmpty()) {
            list.remove(list.size()-1);
        }
    }

    /*private void combinationSum(int [] candidates, int sum , List<Integer> list, List<List<Integer>> finalList, int start ) {
        if(sum == 0) {
            finalList.add(new ArrayList<>(list));
            if(!list.isEmpty()) {
                list.remove(list.size()-1);
            }

            return;
        }
        if(sum < 0) {
            list.remove(list.size()-1);
            return;
        }

        for(int i = start; i<candidates.length ; i++) {
            int x = candidates[i];
            if( sum - candidates[i] >= 0) {
                list.add(candidates[i]);
                combinationSum(candidates, sum -candidates[i], list, finalList, i);
            }
        }
        if(!list.isEmpty()) {
            list.remove(list.size()-1);
        }

    }*/
}
