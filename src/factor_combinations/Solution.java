package factor_combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        List<List<Integer>> factors = getFactors(12);
        factors.forEach(e -> {
            System.out.println();
            e.forEach(elements -> System.out.print(elements));
        });
    }

    /*public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }*/


    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>>  factors = new ArrayList();
        getFactors(n, factors, new ArrayList<Integer>(), 2);
        return factors;
    }


    private static void getFactors(int n, List<List<Integer>>  factors, List<Integer> list, int start) {
        if(n<=1) {
            if(list.size() > 1) {
                factors.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i =start; i<=n;i++) {
            if(n%i == 0) {
                list.add(i);
                getFactors(n/i, factors, list, i );
               list.remove(list.size()-1);
            }
        }

    }
}
