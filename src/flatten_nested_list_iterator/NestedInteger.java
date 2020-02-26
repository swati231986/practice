package flatten_nested_list_iterator;

import java.util.List;

public class NestedInteger {
    Integer num;
    List<NestedInteger> list;

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger() {
        return num != null;
      }

     // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger() {
        return num;
      }

      // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList() {
        return list;
      }
}
