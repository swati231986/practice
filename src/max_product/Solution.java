package max_product;

public class Solution {

    public static void main(String [] args) {
        int [] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if(nums.length == 0) {return -1;}
        int maxProd = Integer.MIN_VALUE;
        int prevMaxProd = 1;
        int prevMinProd = 1;
        int currentMaxProd = Integer.MIN_VALUE;
        int currentMinProd = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {

            //case 1: current element is positive

                currentMaxProd = Math.max(Math.max(prevMaxProd *nums[i],  prevMinProd*nums[i]), nums[i]);

            //case 2: current element is negative

                currentMinProd = Math.min(Math.min(prevMaxProd *nums[i],  prevMinProd*nums[i]), nums[i]);

            maxProd = Math.max(Math.max(maxProd, currentMaxProd), currentMinProd);
            prevMaxProd = currentMaxProd;
            prevMinProd = currentMinProd;
        }

        return maxProd;
    }
}
