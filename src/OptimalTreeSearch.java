/**
 * Created by schaturvedi on 12/27/17.
 */
public class OptimalTreeSearch {

    public static void main(String[] args) {
        int []input = {4,2,6,3};
        int []freq = {10,12,16,21};


    }
    public static int minCost(int []input, int[]freq) {
        int T[][] = new int[input.length][input.length];

        //all diagonal elements of the matrix are defined here - l=1
        for(int i=0;i<input.length;i++) {
            T[i][i] = freq[i];
        }

        for(int l = 2; l<input.length;l++) {
            for(int i=0;i<input.length;i++) {
                int j = i+l-1;
            }
        }

        return 0;
    }
}
