package permutation_string;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String [] args) {
        Permutation perm = new Permutation();
        List<String> result = perm.getPermutations("aa");
        result.forEach(e -> System.out.println(e));
    }

    private List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        getPermutations( "", str, permutations);
        return permutations;
    }


    public void getPermutations(String permutation, String remaining,   List<String> permutations) {

        if(remaining.isEmpty()) {
            permutations.add(permutation);
            return;
        }

        for(int i = 0; i<remaining.length(); i++){
            char c = remaining.charAt(i);

            String s = "";

            if(i == 0) {

                getPermutations(permutation+c, remaining.substring(i+1), permutations);
            } else {
                getPermutations(permutation+c, remaining.substring(0,i) + remaining.substring(i+1), permutations);
            }
        }

    }
}
