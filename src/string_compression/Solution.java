package string_compression;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String [] args) {
        //char[] chars = {'a','a','b','b','c','c','c', 'a'};
        //char[] chars = {'a','a','b','b','c','c','c'};
        //char[] chars = {'a', 'b', 'c'};
        //char[] chars = {'a','a','a','a','a','a','a','a','a','a','a','a'};
        char[] chars = {'a','a'};
        Solution s = new Solution();
        int newLen = s.compress(chars);
        System.out.println(newLen);
        for(char c: chars) {
            System.out.print(c + " ");
        }
    }

    public int compress(char [] chars) {
        if(chars.length == 0) {return 0;}
        if(chars.length == 1) {return 1;}
        if(chars.length == 2 ) {
            if(chars[0] == chars[1]) {
                chars[1] = '2';
            }
            return 2;
        }

        int index = 0;
        char c = chars[0];
        int freq = 1;
        for(int i = 1; i<=chars.length; i++) {
            freq = 1;
            while(i < chars.length && chars[i] == c) {
                freq++;i++;
            }
            chars[index] = c;
            if(freq != 1) {
                for(char x:Integer.toString(freq).toCharArray()) {
                    chars[++index] = x;
                }

            }
            c = i < chars.length ? chars[i] : c;
            index++;

        }

        return index;
    }

    /*public int compress(char[] chars) {
        if(chars.length == 0) {return 0;}
        if(chars.length == 1) {return 1;}
        if(chars.length == 2 ) {
            if(chars[0] == chars[1]) {
                return 1;
            }
            return 0;
        }

        Map<Character, Integer> freq = new HashMap();
        int finalLength = 0;
        for(int i = 0; i<chars.length; i++) {
            if(freq.containsKey(chars[i]) && freq.get(chars[i]) == 1) {
                finalLength++;
                freq.put(chars[i],2);
            } else if(!freq.containsKey(chars[i])) {
                finalLength++;
                freq.put(chars[i],1);
            } else if(freq.containsKey(chars[i]) && freq.get(chars[i]) >= 2) {
                int count = freq.get(chars[i]);
                freq.put(chars[i],++count);
            }
        }

        char [] finalChar = new char[finalLength];
        int index = 0;
        for(int i =0; i<chars.length ;i++) {
            if(freq.containsKey(chars[i])) {
                chars[i] = chars[i];
                if(freq.get(chars[i]) > 1) {
                    i++;
                    chars[i] = Character.forDigit(freq.get(chars[i-1]), 10);
                    i = i + freq.get(chars[i-1])-2;
                }

            }

        }
        //chars = finalChar;
        return finalLength;
    }*/
}
