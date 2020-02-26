package ismountain;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int []A = {2,1,4,7,3,2,5};
        int result = s.longestMountain(A);
        System.out.println(result);
    }

    boolean isMountain = false;
    public int longestMountain(int[] A) {

        if(A.length == 0) {return 0;}

        int start = 0;
        int max = Integer.MIN_VALUE;
        while(start < A.length-1) {
            int end = getMountain(A, start);
            if(isMountain) {
                max = Math.max(max, end-start);
                System.out.println(start + " " + end);
            }
            //start = end + 1 > start ? end - 1 : end;
            start = Math.max(start+1, end-1);
        }

        max = max == Integer.MIN_VALUE ? 0 : max;
        return max;
    }

    private int getMountain(int [] A, int start) {
        isMountain = false;
        boolean goHigh = false;
        boolean goLow = false;
        int end = start+1;
        while( end<A.length && start< A.length && A[start] < A[end] ) {
            end++;
            start++;
            goHigh = true;
        }
        while( end<A.length && start< A.length && A[start] > A[end] ) {
            end++;
            start++;
            goLow = true;
        }
        if(goLow && goHigh) {isMountain = true; return end;}
        return end;
    }
}
