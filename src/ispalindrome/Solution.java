package ispalindrome;

public class Solution {
    public static void main(String [] args) {
        Solution s = new Solution();
        //boolean result = s.isPalindrome("0P");
        //boolean result = s.validPalindrome("abhca");
        boolean result = s.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        //boolean result = s.validPalindrome("enbbe");
       //boolean result = s.validPalindrome("abca");
       //boolean result = s.validPalindrome("aba");
       //boolean result = s.validPalindrome("abmbbxa");
       //boolean result = s.validPalindrome("deeee");






        System.out.println(result);
    }

    public boolean validPalindrome(String s) {
        if(s.isEmpty()) {return false;}

        int l = 0;
        int r = s.length()-1;
        while (l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l+1,r) || isPalindrome(s, l, r-1);
            }
            l++;r--;
        }


        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while( l < r) {
            if(s.charAt(l) != s.charAt(r)) {return false;}
            l++; r--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {return true;}

        int start = 0;
        int end = s.length() -1;

        while(start<end) {
            char a = s.charAt(start);
            char b = s.charAt(end);
            if(Character.isLetter(a)) {
                a = Character.toLowerCase(a);
            } else if(!Character.isDigit(a)) {
                start++;
                continue;
            }
            if(Character.isLetter(b)) {
                b = Character.toLowerCase(b);
            } else if(!Character.isDigit(b)) {
                end--;
                continue;
            }
            if(a != b) {return false;}
            start++; end--;
        }
        return true;
    }
}
