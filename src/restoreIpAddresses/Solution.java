package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ///List<String> result = s.restoreIpAddresses("25525511135");
        List<String> result = s.restoreIpAddresses("2222");
        result.forEach(e -> System.out.println(e));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {

        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);
        System.out.println(restored);
        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
    /*public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList();

        recur(s, 3, -1, list, "");
        return list;
    }



    private void recur(String s, int points, int currPoint, List<String> list, String ipAddress) {
      //  System.out.println(ipAddress);
        if(points == 0 ) {
            String str = s.substring(currPoint+1);
            ipAddress = ipAddress + str;
            if(isValidIp(ipAddress) && ipAddress.length() == s.length() + 3) {
                list.add(ipAddress);
            }
        }

        int maxIndex = Math.min(currPoint + 4, s.length());
        for( int i = currPoint+1; i< maxIndex; i++) {
            String subStr = s.substring(currPoint + 1, i+1);
            if(isValid(subStr) && points - 1 >= -1) {

                recur(s, points - 1, i, list, ipAddress + subStr + ".");

            }
        }
    }

    private boolean isValid(String str) {
        int i = Integer.parseInt(str);
        if(i>0 || i<=255) {
            return true;
        }

        return true;
    }

    private boolean isValidIp(String str) {
        String[] arr = str.split("\\.");
        if(arr.length !=4 ) {
            return false;
        }

        for(String ip:arr) {
            int i = Integer.parseInt(ip);
            if(i<=0 || i>255) {
                return false;
            }
        }

        return true;
    }*/
}
