package numberToWords;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String numberToWords(int num) {
        if(num == 0) {return "Zero";}

        StringBuilder sb = new StringBuilder();

        int billion = num/1000000000;
        if(billion > 0) {
            sb.append(getOnes(billion)).append(" ").append("Billion");
        }

        int million = (num - billion*1000000000);
        million = million/1000000;
        if(million > 0) {
            if(million>99) {
                sb.append(" ").append(getThree(million));
            }
            int twos = million%100;
            if(twos>0) {
                sb.append(" ").append(getAllTwos(twos));

            }
            sb.append(" ").append("Million");
        }

        int thousands = (num - (billion*1000000000 + million*1000000))/1000;

        if(thousands > 0) {
            if(thousands>99) {
                sb.append(" ").append(getThree(thousands));
            }
            int twos = thousands%100;
            if(twos>0) {
                sb.append(" ").append(getAllTwos(twos));
            }
            sb.append(" ").append("Thousand");
        }

        int hundred = num - (billion*1000000000 + million*1000000 + thousands*1000);
        if(hundred > 0) {
            if(hundred>99) {
                sb.append(" ").append(getThree(hundred));
            }
            int twos = hundred%100;
            if(twos > 0) {
                sb.append(" ").append(getAllTwos(twos));
            }

        }

        String result = sb.toString().trim();
        return result;

    }

    private String getThree(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num /100;
        sb.append(getOnes(hundred)).append(" ").append("Hundred");

        return sb.toString();
    }

    private String getOnes(int num) {
        Map<Integer, String> map = new HashMap();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        return map.get(num);
    }

    private String getTwos(int num) {
        Map<Integer, String> map = new HashMap();
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        return map.get(num);
    }

    private String getTens(int num) {
        Map<Integer, String> map = new HashMap();
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        return map.get(num);
    }

    private String getAllTwos(int num) {
        StringBuilder sb = new StringBuilder();

        if(num < 10) {
            sb.append(getOnes(num));
            return sb.toString();
        }
        if(num<20) {
            sb.append(getTwos(num));
            return sb.toString();
        }
        int y = num/10;
        sb.append(getTens(y*10));

        int z = num%10;
        if(z > 0) {
            sb.append(" ").append(getOnes(z));
        }

        return sb.toString();

    }

    public static void main(String [] args) {

        Solution s = new Solution();
        String word = s.numberToWords(100000);
        System.out.println(word);
    }

}
