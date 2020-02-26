package generatePalindromes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String>  result = s.generatePalindromes("aaaaaaaaaaaaaaaaaaaaaa");
        result.forEach(e -> System.out.println(e));
    }
    public List<String> generatePalindromes(String s) {
        if(s ==null || s == "") {
            return new ArrayList();
        }

        int[] map = new int[128];

        char st[] = new char[s.length()/2];

        char ch = 0;
        int k = 0;

        if(!hasPalindrome(s, map)) {return new ArrayList();}

        for(int i =0; i<map.length; i++) {
            if(map[i] % 2 == 1) {
                ch = (char)i;
            }

            for(int j=0;j<map[i]/2;j++) {
                st[k++] = (char)i;
            }
        }

        Set<String> result = new HashSet();
        getPermutations(new String(st), ch, result);
        return new ArrayList(result);

    }

    private boolean hasPalindrome(String s, int []map) {
        int count =0;
        for(int i =0; i<s.length(); i++) {
            map[s.charAt(i)]++;
            if(map[s.charAt(i)]%2 ==0 ) {
                count--;
            } else {
                count++;
            }
        }
        if(count <= 1) {return true;}
        return false;
    }

    private Set<String> getPermutations(String str, char ch,  Set<String> result ) {
        getPermutations(str, "", result, ch);
        return result;
    }

    private void getPermutations(String str, String perm, Set<String> result, char ch) {
        if(str.isEmpty()) {
            String s = perm + (ch == 0 ? "" : ch) + new StringBuilder(new String(perm)).reverse();
            if(!result.contains(s)) {result.add(s);}
            return;
        }

        for(int i =0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0) {
                getPermutations(str.substring(i+1), perm+c, result, ch);
            } else {
                getPermutations(str.substring(0,i) + str.substring(i+1), perm+c, result, ch);
            }
        }
    }
}
