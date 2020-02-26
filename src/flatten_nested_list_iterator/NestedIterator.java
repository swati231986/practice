package flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    /*Stack<NestedInteger> stack = new Stack();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() -1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }

    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(stack.peek().isInteger()) {
                return true;
            }

            List<NestedInteger> nestedIntegerList = stack.peek().getList();
            stack.pop();

            for(int i = nestedIntegerList.size() -1; i>=0; i--) {
                stack.push(nestedIntegerList.get(i));
            }


        }
        return false;
    }*/

    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null; //Just in case
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((nextInt = stack.peek().next()).isInteger()) return true;
            else stack.push(nextInt.getList().iterator());
        }
        return false;
    }
}