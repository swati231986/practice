package hIndex;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] citations = {100};
        int result = s.hIndex(citations);
        System.out.println(result);
    }

    public int hIndex(int[] citations) {
        if(citations.length == 0) {return 0;}

       /* int i =0;
        while(i < citations.length && citations[citations.length - i-1] > i) {
            i++;
        }

        return i;*/

        int start = 0; int end = citations.length;

        while(start != end) {
            int mid = (start + end)/2;

            if(citations[mid] == citations.length - mid) {return  citations.length - mid;}
            if(citations[mid] < citations.length - mid) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return citations.length - start;
    }
}
