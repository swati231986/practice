package shortest_distance;

public class Solution {
    public static void main(String [] args) {
        int graph [][] = {{0,3,5,-1}, {3,0,-1,7}, {5,-1,0,6}, {-1,7,6,0}};
    }

   /* public static int shortestDistance( int graph[][], int source, int destination) {
        int solution[] = new int[graph.length];
        for( int i = 0; i<graph.length ; i++ ) {
            int distSourceToi = graph[i][source];
            if(distSourceToi != -1) {
                solution[i] = distSourceToi;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j<graph[i].length ; j++) {
                    if(graph[i][j] != -1 && graph[i][j] != 0) {
                        if(solution[j] + graph[i][j] < min) {
                            min = solution[j] + graph[i][j];
                        }
                    }
                }
            }
        }
    }*/
}
