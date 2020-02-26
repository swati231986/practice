package trappingrainwater;

import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        //int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int [] height = {2,1,0,2};
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution s = new Solution();
        int totalArea = s.trap(height);
        System.out.println(totalArea);
    }
    public int trap(int[] height) {
        if(height.length == 0) {return 0;}


        Stack<Integer> stack = new Stack();

        int prevMax = -1;
        int index = 0;
        int area = 0;

        while(   index <height.length) {
            while(index<height.length &&(stack.isEmpty() || prevMax == -1 || height[prevMax] > height[index]) ) {
                stack.push(index);
                prevMax = prevMax == -1 ? index : (height[prevMax] < height[index] ? index : prevMax);
                index++;
            }

            while(!stack.isEmpty() && index<=height.length) {
                if(index == height.length) {index--;}
                int x = stack.pop();
                area = area + ((Math.min(height[prevMax] , height[index]) - height[x]) * 1);
            }


        }
        return area;

    }
    /*int trap(int [] height) {
        if(height.length == 0) {return 0;}


        int left = 0;
        int right = height.length -1;
        int maxLeft = Integer. MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int area = 0;

        while(left<right) {
            if(height[left] < height[right]) {
                maxLeft = Math.max(height[left], maxLeft);
                area = area + (maxLeft - height[left]);
                left++;
            } else {
                maxRight = Math.max(height[right], maxRight);
                area = area + (maxRight - height[right]);
                right--;
            }
        }

        return area;
    }*/


}
