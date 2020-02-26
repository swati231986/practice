package MedianFinder;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b-a);
    PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> a-b);

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>((a,b) -> b-a);
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(min.size() == 0 && max.size() == 0) {
            max.add(num);
        } else if(min.size() == 0  ) {
            if(num > max.peek()) {
                min.add(num);
            } else {
                int n = max.remove();
                max.add(num);
                min.add(n);
            }

        } else if(max.size() == 0) {
            if(num > min.peek()) {
                int n = min.remove();
                max.add(n);
                min.add(num);
            } else {
                max.add(num);
            }
        } else {
            if(num < min.peek() && num > max.peek()) {
                if(min.size() < max.size()) {
                    min.add(num);
                } else {
                    max.add(num);
                }
            } else if( num <= max.peek()) {
                if(max.size() > min.size()) {
                    int n = max.remove();
                    min.add(n);
                }
                max.add(num);
            } else if(num >= min.peek()) {
                if(min.size() > max.size()) {
                    int n = min.remove();
                    max.add(n);
                }
                min.add(num);
            }
        }
    }

    public double findMedian() {
        int a = 0, b = 0;
        if(min.size() != 0) {
            a = min.peek();
        }
        if(max.size() != 0) {
            b = max.peek();
        }
        if((max.size() + min.size() ) %2 == 0) {
            return (double) (a+b)/2;
        }
        if(min.size() > max.size()) {return min.peek();}
        return max.peek();
    }

}
