package generate_paranthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {


    public static void main(String [] args) {
        List<String> permutations = generateParenthesis(3
        );
        permutations.forEach(e -> System.out.println(e));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> permutations = new ArrayList();
        generateParenthesis(n,  0,0, 0,"", permutations);
        return permutations;
    }

    private static void generateParenthesis(int n, int opening, int closing, int level, String perm, List<String> permutations) {
        if(level == n*2) {
            if(opening == closing) {
                permutations.add(perm);
            }
            return;
        }

        if(opening >= closing && level<n*2)  {
            generateParenthesis(n, opening + 1, closing, level + 1, perm + "(", permutations);
            generateParenthesis(n, opening, closing + 1, level + 1, perm + ")", permutations);
        } else {
            return;
        }
    }

    /*public static List<String> generateParenthesis(int n) {
        if(n ==0) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n ;i++ ) {
            sb.append("()");
        }

        String brackets = sb.toString();
       // System.out.println(brackets);

        List<String> allPermutations = new ArrayList<>();

        generateParenthesis(brackets, allPermutations,  "");
        allPermutations.forEach(e -> System.out.println(e));

        return null;
    }

    private static void generateParenthesis(String brackets, List<String> allPermutations, String perm ) {
        if(brackets.isEmpty() && isValidPermutation(perm) ) {
            allPermutations.add(perm);

        } else {
            for(int i =0; i<brackets.length(); i++) {
                if( i > 0 &&  brackets.charAt(i) == brackets.charAt(i-1)) {
                    continue;
                }
                String newBracket = brackets.substring(0, i) + brackets.substring(i+1, brackets.length());
                if(perm.isEmpty()) {
                    generateParenthesis(newBracket, allPermutations, perm + brackets.charAt(i));

                } else if( perm.charAt(0) != ')') {
                    generateParenthesis(newBracket, allPermutations, perm + brackets.charAt(i));


                }


            }
        }
    }

    private static boolean isValidPermutation(String permutation) {

        Stack<Character> paranthesis = new Stack<>();

        paranthesis.add(permutation.charAt(0));

        for(int i =1; i<permutation.length();i++) {
            if(permutation.charAt(i) == ')') {
                if(paranthesis.isEmpty()) {return false;}
                paranthesis.pop();
            } else if(permutation.charAt(i) == '(') {
                paranthesis.push(permutation.charAt(i));
            }
        }

        if(paranthesis.isEmpty()) {return true;}

        return false;
    }*/
}
