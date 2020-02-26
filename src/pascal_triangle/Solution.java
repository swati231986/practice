package pascal_triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String [] args) {
        Solution sc = new Solution();
        List<List<Integer>> result = sc.generate(5);

        result.forEach(e -> {
            System.out.println();
            e.forEach(element -> System.out.print(element));
        });
    }
    Map<String, Integer> map = new HashMap();
    public List<List<Integer>> generate(int numRows) {


        if(numRows == 0) {return new ArrayList();}

        List<List<Integer>> result = new ArrayList();

        for(int i =1;  i <=numRows; i++) {
            List<Integer> list = new ArrayList();
            for(int j= 1; j<=i; j++) {
                int val = calculate(i,j);
                list.add(val);
            }
            result.add(list);
        }

        return result;
    }

    private Integer calculate(int row, int col) {
        if(this.map.containsKey(row + " "+ col)) {
            return this.map.get(row + " "+ col);
        }

        if(row == col || col == 1) {
            this.map.put(row + " "+ col, 1);
            return 1;
        }

        if(row < 1 || col > row || col <1) {return 0;}

        int result = calculate(row - 1, col - 1) + calculate( row - 1, col);
        this.map.put(row + " "+ col, result);
        return result;
    }
}
