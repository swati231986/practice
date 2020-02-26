package color_houses;


public class Solution {

    public static void main(String [] args) {
        int[][] costs ={{17,2,17},{16,16,5},{14,3,19}};
        int result  = minCost(costs);
        System.out.println(result);
    }
    public static int minCost(int[][] costs) {


        int minR = costs[0][0];
        int minB = costs[0][1];
        int minG = costs[0][2];

        for(int i =1; i<costs.length ;i++) {
            int red = Math.min(minB, minG) + costs[i][0];
            int blue = Math.min(minR, minG) + costs[i][1];
            int green = Math.min(minR, minB) + costs[i][2];
            minR = red;
            minB = blue;
            minG = green;
        }

        return Math.min(Math.min(minR, minB), minG);
    }



}