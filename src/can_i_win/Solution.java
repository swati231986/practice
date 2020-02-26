package can_i_win;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        boolean result = canIWin(10, 40);
        //boolean result = canIWin(5, 7);
        System.out.println(result);
    }

    /*public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0 || maxChoosableInteger == 0) {return false;}
        if(desiredTotal == 1 ) {return true;}
        Set<Integer> numUsed = new HashSet();

        return eachStep(maxChoosableInteger, desiredTotal, 0,1, 1, numUsed);
    }

    private static boolean eachStep(int maxChoosableInteger, int desiredTotal, int sum, int stepCount, int start, Set<Integer> numUsed) {

        if(sum == desiredTotal && numUsed.size()%2 == 1) {
            return true;
        }
        if(sum > desiredTotal) {
            return false;
        }
        for(int i =start;i<=maxChoosableInteger; i++) {
            if(!numUsed.contains(i)) {
                numUsed.add(i);
                System.out.println(sum + " "+i);
                if(eachStep(maxChoosableInteger, desiredTotal,sum+i, stepCount+1, start+1,numUsed)) {
                    numUsed.remove(i);
                    return true;
                }
                numUsed.remove(i);
            }
        }

        return false;
    }*/

    static Map<String, Boolean> memo; // key: chosen[] to string, value: canIWinWithSituation return value when chosen to string is key

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= maxChoosableInteger)
            return true;
        if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
            return false;
        }
        memo = new HashMap<>();

        boolean result = canIWinWithSituation(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
        return result;
    }

    private static boolean canIWinWithSituation(int maxChoosableInteger, int curDesiredTotal, boolean[] chosen) {

        if (curDesiredTotal <= 0) {
            return false;
        }

        String chosenSerialization = Arrays.toString(chosen);
        if (memo.containsKey(chosenSerialization)) {
            return memo.get(chosenSerialization);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (chosen[i]) {
                continue;
            }
            chosen[i] = true;
            if (!canIWinWithSituation(maxChoosableInteger, curDesiredTotal - i, chosen)) {
                memo.put(chosenSerialization, true);
                chosen[i] = false;
                return true;
            }
            chosen[i] = false;
        }
        memo.put(chosenSerialization, false);
        return false;
    }
}
