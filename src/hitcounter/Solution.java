package hitcounter;

public class Solution {

    public static void main(String[]args) {
        HitCounter hitCounter = new HitCounter();

       /* hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        int result = hitCounter.getHits(4);
        System.out.println(result);
        hitCounter.hit(300);
        result = hitCounter.getHits(300);
        System.out.println(result);

        result = hitCounter.getHits(301);
        System.out.println(result);*/

        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(300);
        int result = hitCounter.getHits(300);
        System.out.println(result);
    }
}
