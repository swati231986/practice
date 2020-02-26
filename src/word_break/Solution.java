package word_break;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        Set<String> dict = Stream.of("apple", "pen").collect(Collectors.toSet());
        dict = Stream.of("cats", "dog", "sand", "and", "cat").collect(Collectors.toSet());

        boolean result = s.wordBreak("catsandog", dict);
        System.out.println(result);
    }
    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){

                String x = s.substring(j, i);
                if(f[j] && dict.contains(x)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
