package findAnagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution    {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> anagrams = s.findAnagrams("eidboaoo", "ab");
        anagrams.forEach(e -> System.out.println(e));
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s == "" || p == null || p == "") {return new ArrayList();}
        int []hash = new int[256];
        int start = 0;
        int end = 0;
        int count = p.length();
        List<Integer> result = new ArrayList();

        for(int i = 0; i<p.length(); i++) {
            hash[p.charAt(i)] =  hash[p.charAt(i)] + 1;
        }
        while(end<s.length()) {
            char c = s.charAt(end);
            if(hash[c] >= 1) {
                count--;


            }
            hash[c]--;
            end++;
            if(count == 0) {result.add(start);}
            if(end-start == p.length()) {
                if(hash[s.charAt(start)] >= 0) {
                    count++;
                }
                hash[s.charAt(start)]++;
                start++;
            }
        }
        return result;
    }

}
