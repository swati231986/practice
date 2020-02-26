package numRescueBoats;

import java.util.Arrays;

public class Solution {

    public static void main(String [] args) {
        int arr[] = {3,5,3,4};
        Solution s = new Solution();
        int result = s.numRescueBoats(arr, 5);
        System.out.println(result);
    }

    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 0 || limit == 0) {return 0;}

        Arrays.sort(people);


        int count = 0;
        int start = 0;
        int end = people.length - 1;

        while(start <= end) {
            if(start != end && people[start] + people[end] <= limit) {
                start++;
            }
            count++;
            end--;
        }
        return count;
    }
}
