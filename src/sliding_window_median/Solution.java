package sliding_window_median;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        //int [] nums = {1,3,-1,-3,5,3,6,7};
        int [] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
        Solution s = new Solution();
        double[] medians = s.medianSlidingWindow(nums, 3);
        Arrays.stream(medians).forEach(e -> System.out.println(e));
    }

    PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b) -> b-a);
    PriorityQueue<Integer> min = new PriorityQueue();

    public double[] medianSlidingWindow(int[] nums, int k) {
        if( nums.length < k) {
            return new double[1];
        }
        int len = nums.length;

        double[] result = new double[1 + len-k];

        for(int  i = 0; i<k; i++) {
            add(nums[i]);
        }
        result[0] = findMedian();
        int count = 1;
        for(int i = k; i< nums.length; i++) {
            remove(nums[i-k]);
            add(nums[i]);
            result[count] = findMedian();
            count++;
        }

        return result;
    }

    private void add(int num) {

        if(max.size() == 0 && min.size() == 0) {
            max.add(num);

        } else if(max.size() == 0) {
            if(num <= min.peek()) {
                max.add(num);
            } else {
                int n = min.remove();
                max.add(n);
                min.add(num);
            }
        } else if(min.size() == 0) {
            if(num >= max.peek()) {
                min.add(num);
            } else {
                int n = max.remove();
                min.add(n);
                max.add(num);
            }
        } else {

            if(num > max.peek() && num < min.peek()) {
                if(max.size() < min.size()) {
                    max.add(num);
                } else {
                    min.add(num);
                }
            } else if(num <= max.peek()) {
                if(max.size() > min.size()) {
                    int n = max.remove();
                    min.add(n);
                }
                max.add(num);
            } else {
                if(min.size() > max.size()) {
                    int n = min.remove();
                    max.add(n);
                }
                min.add(num);
            }

        }
    }

    private void remove(int num) {
        if(num <= max.peek()) {
            max.remove(num);
        } else if(num >= min.peek()) {
            min.remove(num);
        }

        if(min.size() == max.size()) {return;}

        if(min.size() < max.size()) {
            int n = max.remove();
            min.add(n);
        } else {
            int n = min.remove();
            max.add(n);
        }
    }

    private double findMedian() {
        if(min.size() == max.size()) {
            int a = min.peek();
            int b = max.peek();
            return (double)(a+b)/2;
        }

        if(min.size() > max.size()) {
            return (double)min.peek();
        }
        return (double)max.peek();

    }
}
