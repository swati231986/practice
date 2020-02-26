package mergeklists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String [] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        /*ListNode list1 = new ListNode(2);
        ListNode list2 = null;
        ListNode list3 = new ListNode(-1);*/

        ListNode [] listNodes = {list1, list2, list3};

        /*ListNode list1 = null;
        ListNode list2 = new ListNode(1);
        ListNode [] listNodes = {list1, list2};*/

        ListNode mergedList = mergeKLists(Arrays.asList(listNodes));

        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }


    /*public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }*/

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    /*public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ) {return null;}
        if(lists.length == 1) {return lists[0];}

        ListNode prevList = lists[0];

        for(int i = 1; i<lists.length; i++) {
            ListNode list = lists[i];
            prevList = mergeLists(prevList, list);
        }

        return prevList;
    }

    public static ListNode mergeLists(ListNode node1, ListNode node2) {
        ListNode pointer1 = node1;
        ListNode pointer2 = node2;
        ListNode node = null;
        if(pointer1 != null && pointer2 != null && pointer1.val < pointer2.val) {
            node = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
        } else if(pointer2 != null) {
            node = new ListNode(pointer2.val);
            pointer2 = pointer2.next;
        } else if(pointer1 != null) {
            node = new ListNode(pointer1.val);
            pointer1 = pointer1.next;
        }
        ListNode prev = node;
        ListNode mergedList = prev;
        while(pointer1 != null && pointer2 != null) {
            node = null;
            if(pointer1.val < pointer2.val) {
                node = new ListNode(pointer1.val);
                pointer1 = pointer1.next;
            } else {
                node = new ListNode(pointer2.val);
                pointer2 = pointer2.next;
            }

            prev.next = node;
            prev = node;

        }
        if(pointer1 == null) {
            if(prev != null) {
                prev.next = pointer2;
            }
        } else if(pointer2 == null) {
            if(prev != null) {
                prev.next = pointer1;
            }
        }
        return mergedList;
    }*/
}
