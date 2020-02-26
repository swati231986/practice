package longest_palindrome;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = s.longestPalindrome("cbbd");
        System.out.println(str);
    }

    int start, maxLength;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        for(int i=0; i<s.length()-1; i++) {

            findPalindrome(i, i, s);
            findPalindrome(i, i+1, s);
        }

        return s.substring(start, maxLength+start);
    }

    private void findPalindrome(int i, int j, String s) {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if(j-i-1 > maxLength) {
            maxLength = j-i-1;
            start = i+1;
        }
    }

   /* private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }*/
}
