package mysqrt;

public class Solution {

    public static void main(String []args) {
        Solution s = new Solution();
       // int sqrt = s.mySqrt(2147483647);
        int sqrt = s.mySqrt(2);

        System.out.println(sqrt);
    }
    public int mySqrt(int x) {
        if(x==1) {return 1;}
        if(x == 0) {return 0;}
        return binarySearch(1,x-1,x);

    }
    public int binarySearch(int start, int end, int x) {

        if(start > end ) {return 0;}
        int mid = (start + end ) /2;
        if(mid  == x/mid) {return mid;}

        // if(mid == Integer.MAX_VALUE) {return max;}

        if(mid > x/mid) {

            return binarySearch(start, mid-1, x);
        } else {
            if((mid+1) >x/(mid+1) ) {
                return mid;
            }  else {
                return binarySearch(mid+1, end, x);
            }

        }

    }
}
