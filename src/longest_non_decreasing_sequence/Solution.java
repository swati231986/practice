package longest_non_decreasing_sequence;

public class Solution {
    public static void main(String [] args) {
        int [] array = {5, 3, 4, 8, 6, 7};

        System.out.println(getLongestNonDecreasingSequence(array));
    }

    public static int getLongestNonDecreasingSequence( int [] array) {
        int solution [] = new int[array.length];
        solution[0] = 1;
        int max = 1;
        for(int i =1 ;i < array.length; i++) {
            solution[i] = (array[i-1] <= array[i]) ? solution[i-1] + 1 : 1;
           max = (max < solution[i]) ? solution[i] : max;
        }
        return max;
    }
}
