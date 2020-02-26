package shortest_word_distance;

public class Solution {
    public static void main(String [] args) {

        //String [] words = {"practice","makes","perfect","coding","makes"};
        //String [] words = {"abc", "lmn", "perfect", "coding", "makes", "makes", "practice", "cqs",
                //"lmn", "orq", "coding", "xyz", "practice"};
        String [] words = {"a","a","b","b"};
        String word1 = "coding";
        String word2 = "practice";


        WordDistance obj = new WordDistance(words);
        int param_1 = obj.shortest("a","b");
        System.out.println(param_1);

        param_1 = obj.shortest("b","a");
       // param_1 = obj.shortest("makes","coding");
        System.out.println(param_1);
    }
}
