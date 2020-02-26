package largestRectangleArea;

import java.util.Stack;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
        int [] heights = {2,1,5,6,2,3};
        int maxArea = s.largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    public int largestRectangleArea(int[] heights) {

        if(heights.length == 0) {return 0;}

        Stack<Integer> stack = new Stack();
        int top = -1;
        int i = 0;
        int area = -1;
        int maxArea = -1;

        while(!stack.isEmpty() || i < heights.length) {

            while(stack.isEmpty() || (i<heights.length && (top < 0|| heights[i] >= heights[top])) ) {
                stack.push(i);
                top = i;
                i++;
            }

            while(!stack.isEmpty() && top >= 0 && top < heights.length && (i == heights.length  || (i <heights.length && heights[top] > heights[i]))) {
                int curr = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[curr] * i;
                } else {
                    area = heights[curr] * (i-stack.peek()-1);
                }
                maxArea = Math.max(area, maxArea);
                if(!stack.isEmpty()) {
                    top = stack.peek();
                } else {top = -1;}
            }

        }
        return maxArea;
    }
    /*public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {return 0;}

        Stack<Integer> stack = new Stack();
        int maxArea = Integer.MIN_VALUE;
        int area = 0;
        int i =0;
        int index = 0;

        while(!stack.isEmpty() && index < heights.length) {
            while( i < heights.length && index < heights.length && heights[i] >= heights[index]) {
                index = i;
                i++;
                stack.push(index);
            }

            while(index >= 0 && index < heights.length && !stack.isEmpty() && heights[index] < heights[i]) {
                index= stack.pop();
                area = heights[index] * (i-index);
                maxArea = Math.max(maxArea, area);
                index =stack.peek();
            }
        }
        return maxArea;
    }*/
}
