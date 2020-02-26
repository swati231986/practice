package binary_search;

public class Solution {

    public static void main(String []args) {
        int arr[] = {2,6,9,10,15,20,25,90};
        Solution s = new Solution();
        int index = s.binarySearch(arr, 90);
        System.out.println(index);
    }
    /*public int binarySearch(int arr[], int target) {
        return binarySearch(0, arr.length, target, arr);
    }
    public int binarySearch(int start, int end, int target, int arr[]) {
        if(start > end) {return -1;}

        int mid = (start + end )/2;

        if(arr[mid] == target) {return mid;}
        if(arr[mid] > target) {
            return binarySearch(start, mid-1, target, arr);
        } else {
            return binarySearch(mid+1, end, target, arr);
        }
    }*/

    public int binarySearch(int [] arr, int target) {

        int start = 0 ;
        int end = arr.length;

        while(start <= end){
            int mid = (start+end)/2;

            if(arr[mid] == target) {return mid;}

            if(arr[mid] > target) {
                start = start;
                end = mid-1;
            } else {
                start = mid+1;
                end = end;
            }
        }

        return -1;
    }


}
