package stack;

public class Solution {
    public static void main(String [] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        //obj.push(5);
        //System.out.println(obj.top());
        System.out.println(obj.popMax());
        //System.out.println(obj.top());
        System.out.println(obj.peekMax());
        //System.out.println(obj.pop());
        //System.out.println(obj.top());
        /*int param_3 = obj.top();
        int param_4 = obj.peekMax();
        int param_5 = obj.popMax();*/
    }
}
