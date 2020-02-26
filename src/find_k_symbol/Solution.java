package find_k_symbol;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        int result = s.kthGrammar(1, 1);
        System.out.println(result);
        result = s.kthGrammar(2, 3);
        System.out.println(result);
        result = s.kthGrammar(15, 1);
        System.out.println(result);
        result = s.kthGrammar(26, 8);
        System.out.println(result);
    }


    public int kthGrammar(int N, int K) {

        String s = grammar(N, K);
        if(K > s.length() || K<=0) {return -1;}
        char c = s.charAt(K-1);
        return c == '0' ? 0 : 1;
    }

    Map<Integer, String> map = new HashMap();

    private String grammar(int N, int K) {
        if(map.containsKey(N)){return map.get(N);}

        if(N == 1) {map.put(1, "0"); return "0";}
        if(N == 2) {map.put(2,"01"); return "01";}
        String str = grammar(N-1, K);
        if(str.length() < K) {return str;}
        StringBuilder sb = new StringBuilder();


        String subStr = str.substring(str.length()/2, str.length());
        for(int i = 0; i<subStr.length(); i++) {
            if(subStr.charAt(i) == '1') {
                sb.append("10");
            } else {
                sb.append("01");
            }
        }
        map.put(N, str+sb.toString());
        return str + sb.toString();
    }
    /*public int kthGrammar(int N, int K) {
        String s = grammar("0", N, 1);
        if(K >  s.length() || K<=0) {return -1;}
        char c = s.charAt(K-1);
        return c == '0' ? 0 : 1;
    }

    private String grammar(String s, int N, int count) {

        if(count == N) {return s;}
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        return grammar(sb.toString(), N, count+1);
    }*/
}
