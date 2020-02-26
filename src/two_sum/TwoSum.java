package two_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    List<Integer> numbers = new ArrayList<>();
    /** Initialize your data structure here. */
    public TwoSum() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
       numbers.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int index = 0;
        for(int i = numbers.size()-1; i>=0; i--) {
            int remainder = value - numbers.get(i);
            if(numbers.indexOf(remainder) != -1 && numbers.indexOf(remainder) != i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args) {
        TwoSum twoSum = new TwoSum();
        /*twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
        twoSum.add(0);
        twoSum.add(0);
        System.out.println(twoSum.find(0));

        twoSum.add(1);
        twoSum.add(2);
        System.out.println(twoSum.find(1));

        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        System.out.println(twoSum.find(2));
        System.out.println(twoSum.find(3));
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(5));
        System.out.println(twoSum.find(6));*/

        twoSum.add(0);
        twoSum.add(-1);
        twoSum.add(-1);
        twoSum.add(0);

        System.out.println(twoSum.find(-2));
        System.out.println(twoSum.find(0));
        System.out.println(twoSum.find(-1));
        System.out.println(twoSum.find(1));

    }
}
