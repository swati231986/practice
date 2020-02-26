package canplaceflowers;

public class Solution {

    public static void main(String [] args) {
        int flowerBed [] = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerBed, 1));
    }

    /*public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int index = 0;
        int count = 0;
        while(index < flowerbed.length) {
            if(flowerbed[index] == 1 ) {index ++;continue;}
            if(index == 0 && (index+1 == flowerbed.length || flowerbed[index+1] == 0)) {
                count++;
                flowerbed[index] = 1;
                index= index+2;
                continue;
            }
            if(index == flowerbed.length - 1 && flowerbed[index-1] == 0 ) {
                count++;
                flowerbed[index] = 1;
                continue;
            }
            if(index > 0 && index < flowerbed.length-1 && flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0) {
                count++;
                flowerbed[index] = 1;
            }
            index++;
        }
        return (count>=n);
    }*/

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1, sum = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0) {
                count++;
            } else{
                sum += (count-1)/2;
                count = 0;
            }
            if(sum >= n) return true;
        }
        return sum+count/2 >= n;
    }
}
