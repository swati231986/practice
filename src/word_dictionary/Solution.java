package word_dictionary;

public class Solution {
    public static void main(String [] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("swati");
        dictionary.addWord("isha");
        dictionary.addWord("josh");
        dictionary.addWord("swat");

        boolean isPresent = dictionary.search("swati");
        System.out.println(isPresent);
        isPresent = dictionary.search("isha");
        System.out.println(isPresent);
        isPresent = dictionary.search("josh");
        System.out.println(isPresent);
        isPresent = dictionary.search("swat");
        System.out.println(isPresent);
        isPresent = dictionary.search("gbreribg");
        System.out.println(isPresent);

        isPresent = dictionary.search("..a");
        System.out.println(isPresent);

        isPresent = dictionary.search("s...");
        System.out.println(isPresent);

        /*WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("a");
        dictionary.addWord("a");

        boolean isPresent = dictionary.search(".a");
        System.out.println(isPresent);*/

    }
}
