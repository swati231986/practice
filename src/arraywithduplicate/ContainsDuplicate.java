package arraywithduplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public enum DaysOfWeekEnum {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public static void main(String [] args) {
        /*List<String> listString = new ArrayList<>();
        listString.add("first");
        listString.add("second");
        String finalString = listString.stream().reduce("", String::concat);
        System.out.println(finalString);
        for(String s:listString) {
            System.out.println(s);
        }

        List<DaysOfWeekEnum> enumList = new ArrayList<>();
        enumList.add(DaysOfWeekEnum.SUNDAY);
        enumList.add(DaysOfWeekEnum.MONDAY);
        String str = enumList.stream().map(value -> value.toString()).reduce("",(day1, day2) -> day1+day2);
        System.out.println(str);*/
        int [] nums = {1,0,1,1};
        Boolean result = containsNearbyDuplicte(nums,1);
        System.out.println(result);
    }
    /*public static boolean containsNearbyDuplicte(int[] nums, int k) {
        Map<Integer, Set<Integer>> firstIndexMap = new HashMap();
        for(int i =0; i< nums.length; i++) {
            Set<Integer> indexSet = null;
            if(firstIndexMap.get(nums[i]) == null) {
                indexSet = new HashSet<>();
                indexSet.add(i);
                firstIndexMap.put(nums[i], indexSet);
                continue;
            }
            indexSet = firstIndexMap.get(nums[i]);
            indexSet.add(i);
            firstIndexMap.put(nums[i], indexSet);
        }

        for(Map.Entry<Integer, Set<Integer>> key: firstIndexMap.entrySet()) {
            Set<Integer> value = key.getValue();
            if(value.size() == 1) {continue;}
            for(Integer index : value) {
                for(int i=index+1;i<=index+k;i++) {
                    if(value.contains(i)) {return true;}
                }
            }
        }

        return false;

    }*/

    public static boolean containsNearbyDuplicte(int[] nums, int k) {
        Map<Integer, Integer> minIndexMap = new HashMap();
        for(int i =0; i< nums.length; i++) {

            if(minIndexMap.get(nums[i]) == null) {
                minIndexMap.put(nums[i], i);
                continue;
            }
            int index = minIndexMap.get(nums[i]);
            int diff = i-index;
            if(diff<=k) {
                return true;
            }
            minIndexMap.put(nums[i],i);
        }

        return false;

    }




}
