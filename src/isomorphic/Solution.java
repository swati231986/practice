package isomorphic;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String [] args) {
        //String s = "abbgajhjhjh";
        //String t = "gttrgwpwpwp";

        String s = "tgtg";
        String t = "eeee";
        System.out.println(isIsomorphic(s,t));
    }

    /*public static boolean isIsomorphic(String s, String t) {
        String template1 = createTemplate(s);

        String template2 = createTemplate(t);

        return template1.equals(template2);
    }*/

    /*public static boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            int x = s2.charAt(i) + 256;
            int y = s1.charAt(i);
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }*/

    private static String createTemplate(String str) {
        Map<Character, String> charMap = new HashMap();

        Integer count = 0;
        String template = "";
        for (int i =0;i<str.length(); i++) {
            Character c = str.charAt(i);
            if(charMap.get(c) == null ) {
                template = template + count.toString();
                charMap.put(c, count.toString());
                count++;
            } else {
                String templateChar = charMap.get(c);
                template = template + templateChar;
            }
        }
        return template;
    }

    public static boolean isIsomorphic(String s, String t) {
        int m1[] = new int[256], m2[] = new int[256], n = s.length();
        m1[0] = 0; m2[0] = 0;
        for (int i = 0; i < n; ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
