package jump_game_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        //int nums[] = {2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2,2,6,3};
        //int nums[] = {2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2};
        //int nums[] = {9,4,5,4,1,8,1,2,0,7,8,7,0,6,6,1,1,2,5,0,9,8,4,7,9,6,8,1,4,0,8,5,5,3,9,8,1,2,2,3,0,1,3,2,7,9,3,0,1};
        int nums[] = {2,3,1,1,4,5,2,6};
        int min = s.jump(nums);
        System.out.println(min);
    }

    public int jump(int[] A) {
        /*int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;*/

        if(A.length<2) {return 0;}
        int level=0,currentMax=0,i=0,nextMax=0;

        while(currentMax-i+1>0){		//nodes count of current level>0
            level++;
            for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
                nextMax=Math.max(nextMax,A[i]+i);
                if(nextMax>=A.length-1)return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax=nextMax;
        }
        return 0;
    }

    /*public int jump(int[] nums) {
        if(nums.length == 0) {return 0;}

        jump(nums, new HashSet<>(), 0, 0);
        return min;
    }
    private int min = Integer.MAX_VALUE;

    private void jump(int []nums, Set<String> tried, int curr, int count) {
        if(count >= min) {return;}
        if(count > nums.length) {
            return;
        }
        if(curr >= nums.length-1) {
            min = Math.min(min, count);
            System.out.println("curr= " + curr+ " min= "+ min + " count = "+count);
            return;
        }
        for(int i = 1; i<=nums[curr] ; i++) {
            if(!tried.contains(curr+""+i)) {
                tried.add(curr+""+i);
                jump(nums, tried, curr+i, count+1);
                tried.remove(curr+""+i);
            }
        }
    }*/

}
