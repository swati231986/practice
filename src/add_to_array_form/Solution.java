package add_to_array_form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String []args) {
        //int [] A = {2,7,4};
        int [] A = {1,0,6};
        Solution s  = new Solution();
        List<Integer> list = s.addToArrayForm(A, 11);
        list.forEach(e -> System.out.println(e));

    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        if(A.length == 0) {return new ArrayList();}
        if(K == 0) {return Arrays.stream(A).boxed().collect(Collectors.toList());}

        int carry  = 0;
        List<Integer> arrayForm = new ArrayList();

        for(int i = A.length - 1 ; i >=0; i--) {
            int sum = A[i] + carry + K%10;
            K = K/10;
            carry =  sum/10;
            sum = sum%10;
            arrayForm.add(0,sum);
        }

        if(carry>=0 && K >=0 ) {
            carry = carry + K;
        }

        while(carry>0) {
            arrayForm.add(0, carry%10);
            carry = carry/10;
        }
        return arrayForm;
    }
}
