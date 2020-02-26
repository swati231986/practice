package convertToTitle;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = s.convertToTitle(701);
        System.out.println(str);
    }

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
