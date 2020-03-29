package findint;

public class Solution {

    public static void main(String [] args){
        Solution s = new Solution();
        int result = s.findIntegers(3);
        System.out.println(result);
    }

    public int findIntegers(int num) {
        return find(0, 0, num, false);
    }
    public int find(int i, int sum, int num, boolean prev) {
        if (sum > num)
            return 0;
        int a = 1<<i;
        if (1<<i > num)
            return 1;
        if (prev)
            return find(i + 1, sum, num, false);
        return find(i + 1, sum, num, false) + find(i + 1, sum + (1 << i), num, true);
    }

   /* public int findIntegers(int num) {

        if(num == 0 || num == 1 || num == 2 ) {
            return num+1;
        }

        int count = getCount(num);
        return num - count +1;
    }*/

    private int getCount(int num) {
        int x = 3;
        int count =0;
        while(x <= num) {
            int sum = x;
            while(num >= sum) {

                count++;
                sum = sum<<1;

            }
            x = x*2 + 1;
        }

        return count;
    }
}
