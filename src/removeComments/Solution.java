package removeComments;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ",
                "int a, b, c;", "/* This is a test",
                "   multiline  ",
                "   comment for ", "   testing */",
                "a = b + c;", "}"};
        List<String> result = s.removeComments(source);
        result.forEach(e -> System.out.println(e));
    }

    public List<String> removeComments(String[] source) {
        if(source.length == 0) {return new ArrayList();}
        List<String> list = new ArrayList();
        int countBlock = 0;

        for(int i =0; i<source.length; i++) {

            int j = commentFound(source[i]);
            if(j == -1 ) {
                if(countBlock == 0) {list.add(source[i]);}
                continue;
            }
            String s = source[i].charAt(j) + "" + source[i].charAt(j+1);
            if(countBlock == 1 && !s.equals("*/")) {
                continue;
            }
            if(s.equals("//")) {
                if(j>0){
                    list.add(source[i].substring(0,j));
                }
            } else if(s.equals("/*")) {
                if(j>0){list.add(source[i].substring(0,j));}
                int x = findComment(source[i], "*/");
                countBlock++;
                if(x > j) {
                    countBlock--;
                }
            } else if(s.equals("*/")) {
                countBlock--;
                if(j+2 < source[i].length()) {
                    list.add(source[i].substring(j+2));
                }
            }
        }
        return list;
    }

    private int findComment(String str, String comment) {
        for(int i =0; i<str.length()-1; i++) {
            String s = str.charAt(i) + "" + str.charAt(i+1);
            if(s.equals(comment)) {
                return i;
            }
        }
        return -1;
    }

    private int commentFound(String str) {
        for(int i =0; i<str.length()-1; i++) {
            String s = str.charAt(i) + "" + str.charAt(i+1);
            if(s.equals("//") || s.equals("/*") || s.equals("*/")) {
                return i;
            }
        }
        return -1;
    }
}
