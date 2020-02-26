package unique_map;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int result = s.uniquePaths(3, 2);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        if(n== 0 || m == 0) {return 0;}

        int result = uniquePath(1,1,n,m);
        return  result;
    }

    private int uniquePath(int x, int y, int n, int m) {
        if(x == n || y == m) {return 1;}

        return uniquePath(x+1, y, n, m) + uniquePath(x, y+1, n, m);
    }
}
