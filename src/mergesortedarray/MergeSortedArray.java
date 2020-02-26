package mergesortedarray;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int [] arr2 = {2,5,6};
        merge(arr1, 3, arr2, 3);
     }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int countA = 0;
        while(countA < m && n>0) {
            if(nums1[countA] <= nums2[0]) {countA++; continue;}
            int temp  = nums1[countA];
            nums1[countA] = nums2[0];
            nums2[0] = temp;
            int countB = 0;
            while(countB+1<n && nums2[countB] >nums2[countB+1]) {
                int t = nums2[countB];
                nums2[countB] = nums2[countB +1];
                nums2[countB + 1] =t;
                countB++;
            }
            countA++;
        }
        int count = 0;

        while(countA< m+n && count <n) {
            nums1[countA] = nums2[count];
            countA++;
            count++;
        }

        for(Integer integer:nums1) {
            System.out.println(integer);
        }
    }
}
