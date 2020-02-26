package flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        List<NestedInteger> nestedIntegers = new ArrayList<>();



        NestedInteger nestedInteger2 = new NestedInteger();
        nestedInteger2.num = 1;
        NestedInteger nestedInteger3 = new NestedInteger();
        nestedInteger3.num = 1;
        List<NestedInteger> nestedIntegers1 = new ArrayList<>();
        nestedIntegers1.add(nestedInteger2);
        nestedIntegers1.add(nestedInteger3);

        NestedInteger nestedInteger1 = new NestedInteger();
        nestedInteger1.list = nestedIntegers1;
        nestedIntegers.add(nestedInteger1);

        nestedInteger1 = new NestedInteger();
        nestedInteger1.num = 2;
        nestedIntegers.add(nestedInteger1);


        nestedInteger2 = new NestedInteger();
        nestedInteger2.num = 1;
        nestedInteger3 = new NestedInteger();
        nestedInteger3.num = 1;
        nestedIntegers1 = new ArrayList<>();
        nestedIntegers1.add(nestedInteger2);
        nestedIntegers1.add(nestedInteger3);

        nestedInteger1 = new NestedInteger();
        nestedInteger1.list = nestedIntegers1;
        nestedIntegers.add(nestedInteger1);


        NestedIterator nestedIterator = new NestedIterator(nestedIntegers);

        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

    }

}
