package buddyStrings;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String []args) {
        Solution s = new Solution();
        boolean result = s.buddyStrings("aa","aa");
        System.out.println(result);
    }

    public boolean buddyStrings(String A, String B) {
        int a = 1; int b= 0;

        if(A.isEmpty() || B.isEmpty()) {return false;}
       /* if(A.equals(B)) {
            if(A.chars().allMatch(c -> c == A.charAt(0))) {return true;}
            //return checkFreq(A);
        }*/
        int diff = 0;
        int lenA = A.length()-1; int lenB = B.length()-1;
        if(lenA != lenB) {return false;}
        Map<Character, Integer> freq = new HashMap<>();
        int countFreq = 1;

        boolean canSwap = false;
        int i = -1; int j = -1;
        while(lenA>=0 && lenB >=0) {

            if(A.charAt(lenA) != B.charAt(lenB)) {
                j = i != -1 ? lenA : j;
                i = i == -1 ?  lenA : i;

                diff++;

            } else {
                if(freq.containsKey(A.charAt(lenA))) {
                    freq.put(A.charAt(lenA), freq.get(A.charAt(lenA)) + 1);
                    countFreq++;
                } else {
                    freq.put(A.charAt(lenA),1);
                }
                if(countFreq == 2) {canSwap = true;}
            }
            lenA--;lenB--;
            if(diff > 2) {return false;}
        }

        if((diff == 2 && A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i)) || (diff == 0 && canSwap)) {
           return true;
        }

        return false;
    }
}
