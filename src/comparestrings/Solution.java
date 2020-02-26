package comparestrings;

public class Solution {

    public static void main(String []  args) {
        String s1 = "";
        String s2 = "";
        System.out.println(areEqual(s1,s2));
    }

    public static boolean areEqual(String s1, String s2) {
        int count1 = 0; int count1Next = 1;
        int count2 = 0; int count2Next = 1;

        while(count1Next < s1.length() && count2Next < s2.length()) {
            if(s1.charAt(count1Next) == '_') {
                count1 = count1 + 2;
                count1Next = count1Next + 2;
            }
            if(s2.charAt(count2Next) == '_') {
                count2 = count2 + 2;
                count2Next = count2Next + 2;
            }

           // if(s2.charAt(count2Next) != '_' && s1.charAt(count1Next) )

        }
        return false;
    }
}
