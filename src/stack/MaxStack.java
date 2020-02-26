package stack;

public class MaxStack {
    private ListNode top;
    private ListNode max;


    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        if(top == null) {
            this.top = new ListNode(x);
            this.top.next = null;
            this.max = this.top;
        } else {
            ListNode newNode = new ListNode(x);
            newNode.next = this.top;
            this.top = newNode;
            if(this.max.val< this.top.val) {
                this.max = this.top;
            }
        }


    }


    public int pop() {
        if(this.top == null) {
            return -1;
        }
        if(this.max == this.top) {
            return removeMaxNode();
        } else {
            int val = this.top.val;
            this.top = this.top.next;
            return val;
        }

    }

    public int top() {
        if(this.top == null) {
            return -1;
        }
        return this.top.val;
    }

    public int peekMax() {
        if(this.max == null) {
            return -1;
        }
        return this.max.val;
    }

    public int popMax() {
        if(this.max == null) {
            return -1;
        }
        return removeMaxNode();

    }

    private int removeMaxNode() {
        ListNode traverse = this.top;
        ListNode prev = null;
        boolean foundMax = false;
        int nextMaxVal = Integer.MIN_VALUE;
        int oldMaxVal = this.max.val;
        ListNode nextMaxNode = null;
        while(traverse != null) {
            if(this.max != null && traverse.val == this.max.val && !foundMax) {
                foundMax = true;
                if(prev != null) {
                    prev.next = traverse.next;

                } else {
                    this.top = this.top.next;

                }

            }
            nextMaxVal = traverse.val >= nextMaxVal && traverse != this.max? traverse.val: nextMaxVal;
            nextMaxNode = (nextMaxVal == traverse.val) ? traverse : nextMaxNode;
            prev = traverse;
            traverse = traverse.next;
        }
        this.max = nextMaxNode;
        return oldMaxVal;
    }


}
