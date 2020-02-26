package zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String []args) {

       String result =  convert("paypalishiring",3);

       System.out.println(result);
    }



    /*public static String convert(String s, int numRows) {
        if(s == null) {return null;}
        if(numRows == 0) {return null;}
        if(numRows == 1) {return s;}

        List<String> result = new ArrayList();

        String row1 = s.substring(0,numRows);
        result.add(row1);

        int count = numRows;
        boolean reverse  = true;
        while(count < s.length()) {
            String str;
            if(count+numRows-1 >= s.length()) {
                str = s.substring(count);
            } else {
                str = s.substring(count, count+numRows-1);
            }

            StringBuilder sb = new StringBuilder(str);
            if(reverse) {
                sb.reverse().append("_");

            } else {
                sb.insert(0, "_");
            }

            if(sb.length() < numRows) {
                int c = sb.length();
                while (c< numRows) {
                    sb.insert(0, "_");
                    c++;
                }
            }

            result.add(sb.toString());
            count = count+numRows-1;
            reverse = !reverse;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<numRows; i++) {
            for(String str: result) {
                if(str.length() > i && str.charAt(i) != '_') {
                    sb.append(str.charAt(i));
                }
            }
        }

        return sb.toString();
    }*/

    public static String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }
}
