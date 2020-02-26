package heap_sort;

public class Solution {

    public static void main(String [] args) {
        /*Heap heap = new Heap(Heap.HeapType.MIN_HEAP);

        heap.insert(6);
        heap.insert(7);
        heap.insert(1);
        heap.insert(9);
        heap.insert(0);

        int result = heap.peek();
        System.out.println(result);

        result = heap.remove();
        System.out.println(result);

        result = heap.peek();
        System.out.println(result);

        result = heap.remove();
        System.out.println(result);

        result = heap.peek();
        System.out.println(result);
        result = heap.remove();
        System.out.println(result);

        result = heap.peek();
        System.out.println(result);
        result = heap.remove();
        System.out.println(result);

        result = heap.peek();
        System.out.println(result);
        result = heap.remove();
        System.out.println(result);

        result = heap.peek();
        System.out.println(result);*/

        int arr[] = {6,1,2,8,5,4,4,0,2,0};

        Solution s = new Solution();
        s.heapSort(arr);
        for(int n:arr) {
            System.out.println(n);
        }


    }

    public void heapSort(int[] arr) {
        for(int i =arr.length - 1 ; i>=0; i--) {
            heapify(arr, arr.length-1, i);
        }
        swap(arr, 0, arr.length-1);
        for(int i = arr.length-2; i>=0; i--) {

            heapify(arr, i, 0);
            swap(arr, 0, i);

        }
    }

    private void heapify(int[] arr, int end, int start) {

           int l = 2 * start + 1;
           int r = 2 * start + 2;

           int max = start;

           if(l <= end && arr[l] > arr[max]) {

               max = l;
           }

           if(r <= end && arr[r] > arr[max]) {

               max = r;
           }
            if(max != start) {
                swap(arr, max, start);
                heapify(arr, end, max);
            }

    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
