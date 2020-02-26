package reverseString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String [] args) {
        String s  = "a good   example";
        System.out.println(reverseWords(s));
        s  = "  hello world!  ";
        System.out.println(reverseWords(s));
        s="the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        if(s == null) {return null;}
        s = s.trim();
        String [] words = s.split("\\s+");
        Collections.reverse(Arrays.asList(words));

        StringBuilder sb = new StringBuilder();
        for(String str: words) {
            sb.append(str).append(" ");
        }

        return sb.toString().trim();
    }
}
