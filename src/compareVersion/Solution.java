package compareVersion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.compareVersion("1.0.1", "1");
        System.out.println(result);
    }
    public int compareVersion(String version1, String version2) {
        String arr[] = version1.split(".");

        List<String> arr1 = Stream.of(version1.split("\\.")).collect(Collectors.toList());
        List<String>  arr2 = Stream.of(version2.split("\\.")).collect(Collectors.toList());
        int len = Math.abs(arr1.size() - arr2.size());
        if(arr1.size() > arr2.size()) {
            for(int i =0; i<len; i++) {
                arr2.add("0");
            }
        } else if (arr1.size() < arr2.size()) {
            for(int i =0; i<len; i++) {
                arr1.add("0");
            }
        }

        for(int i =0; i<arr1.size(); i++) {
            int a = Integer.parseInt(arr1.get(i));
            int b = Integer.parseInt(arr2.get(i));
            if(a > b) {
                return 1;
            } else if(a < b) {
                return -1;
            }
        }

        return 0;
    }
}
