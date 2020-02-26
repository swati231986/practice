package heap_sort;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    public Heap( HeapType type) {
        this.type = type;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    private List<Integer> list = new ArrayList<>();

    public enum HeapType {
        MIN_HEAP,
        MAX_HEAP;

        HeapType() {
        }
    }

    public HeapType getType() {
        return type;
    }

    public void setType(HeapType type) {
        this.type = type;
    }

    private HeapType type;


    public void insert(int num) {
        list.add(num);
        heapifyUp();
    }

    private void heapifyUp() {
        int lastIndex = list.size()-1;

        while (lastIndex > 0) {
            int parent  = -1;
            if(lastIndex %2 == 0){
                parent = (lastIndex - 2 )/2;
            } else {
                parent = (lastIndex - 1 )/2;
            }

            if(this.type == HeapType.MAX_HEAP) {

                if(list.get(parent) < list.get(lastIndex)) {
                    swap(parent, lastIndex);
                }
            } else {
                if(list.get(parent) > list.get(lastIndex)) {
                    swap(parent, lastIndex);
                }
            }
            lastIndex = parent;
        }

    }

    private void swap(int index1, int index2) {
        int num1 = list.get(index1);
        int num2 = list.get(index2);
        list.remove(index1);
        list.add(index1, num2);
        list.remove(index2);
        list.add(index2, num1);
    }

    public int remove() {
        if(list.isEmpty()) {
            return -1;
        }
        int num = list.remove(0);
        if(list.isEmpty()) {
            return num;
        }
        int last = list.remove(list.size()-1);
        list.add(0, last);
        heapifyDown();
        return num;

    }

    private void heapifyDown() {

        int parent = 0;

        while(parent < list.size()-1) {
            int child1 = 2 * parent + 1;
            int child2 = 2 * parent + 2;

            if(child1 <= list.size() -1 && child2 <= list.size() -1) {
                int min = Math.min(Math.min(list.get(parent) , list.get(child1)), list.get(child2));
                if(min == list.get(child1)) {
                    swap(parent, child1);
                    parent = child1;
                } else if (min == list.get(child2)) {
                    swap(parent, child2);
                    parent = child2;
                } else {
                    break;
                }


            } else if(child1 <= list.size() -1) {
                int min = Math.min(list.get(parent), list.get(child1));
                if(min == list.get(child1)) {
                    swap(parent, child1);
                    parent = child1;
                } else {
                    break;
                }
            } else if(child2 <= list.size() -1) {
                int min = Math.min(list.get(parent), list.get(child2));
                if(min == list.get(child2)) {
                    swap(parent, child2);
                    parent = child2;
                } else {
                    break;
                }
            }
        }

    }

    public int peek() {
        if(list.isEmpty())  {
            return -1;
        }
        return list.get(0);
    }


}
