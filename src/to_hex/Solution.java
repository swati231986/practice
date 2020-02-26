package to_hex;


public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        String sb = s.toHex(-24);
        System.out.println(sb);
    }
    public java.lang.String toHex(int num) {
        if(num >= 0 && num <= 9) {
            return ""+num;
        }
        char charArr [] = {'a','b','c','d','e','f'};

        StringBuilder sb = new StringBuilder();



        while(num > 0) {
            int right4Numbers = num & 15;
            num = num >>> 4;
            sb.insert(0,getHexadecimal(right4Numbers));
        }
        return sb.toString();
    }

    private String getHexadecimal(int n) {
        char charArr [] = {'a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        if(n >= 0 && n <= 9) {return n+"";}
        if(n >=10) {
            int diff = 10 - n;
            char c = charArr[diff];
            sb.append(c);
        } else {
            sb.append(n+"");
        }
        return sb.toString();
    }
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex1(int num) {
        if(num == 0) return "0";
        String result = "";

        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

}
