package max_area;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int [] area = {1,8,6,2,5,4,8,3,7};
        int maxArea = s.maxArea(area);
        System.out.println(maxArea);
    }
    public int maxArea(int [] area) {
        if(area.length == 0) {return -1;}
        int max = Integer.MIN_VALUE;


       int l =0;
       int r = area.length-1;

       while(l<r) {
           max = Math.max(area[l] <area[r] ? area[l] * (r-l) : area[r] * (r-l), max);
           if(area[l] < area[r]) {
               l++;
           } else {
               r--;
           }
       }
       return max;
    }
}
