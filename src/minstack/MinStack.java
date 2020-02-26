package minstack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {

    List<Integer> stack = new ArrayList<Integer>();

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
        pq.add(x);
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int element = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        pq.remove(element);

    }

    public int top() {

        int element = stack.get(stack.size()-1);
        return element;
    }

    public int getMin() {
        int min = pq.peek();
        return min;
    }
}
