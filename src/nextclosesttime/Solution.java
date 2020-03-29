package nextclosesttime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.nextClosestTime("23:59");
        System.out.println(result);
    }

    public String nextClosestTime(String time) {

        Set<Character> set = new HashSet();

        for(char t:time.toCharArray()) {
            if(t==':') {
                continue;
            }
            set.add(t);
        }
        String timeForward =time;

        while(true) {
            String hours = timeForward.split(":")[0];
            String minutes = timeForward.split(":")[1];

            Integer min = Integer.parseInt(minutes) + 1;
            Integer hour = Integer.parseInt(hours) ;

            while(min >= 60 || hour >= 24) {
                if(min>=60) {
                    hour = hour + min/60;
                    min = min%60;
                }
                hours = hour.toString();
                if(hour>=24) {
                    hour = hour - 24;
                    hours = "0"+ hour.toString();
                }
            }
            if(hours.length() == 1) {
                hours = "0" + hours;
            }
            minutes = min.toString();
            if(min.toString().length() == 1) {
                minutes = "0" + minutes;
            }
             timeForward = hours+ ":" + minutes;

            System.out.println(timeForward);
            boolean valid = true;
            for(char c:timeForward.toCharArray()) {
                if(!set.contains(c) && c != ':') {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                return timeForward;
            }


        }



    }
   /* public String nextClosestTime(String time) {
        List<String> permutations = new ArrayList();
        getPermutations(time, "", permutations);
        String result = "";
        int min = Integer.MAX_VALUE;
        for(String str:permutations) {
            if(str.equals(time)) {continue;}
            int diff = findDiff(str, time);
            if(diff>0) {
                min = Math.min(diff, min);
                if(min == diff) {
                    result = str;
                }
            }
        }
        return result;
    }

    private void getPermutations(String time, String perm, List<String> permutations) {

        if(perm.length() == 5) {
            if(isValid(perm)) {
                permutations.add(perm);
            }

            return;
        }

        for(int i = 0; i<time.length() ; i++) {
            char c = time.charAt(i);
            String t = "";
            if(i == 0) {
                t = time.substring(i+1);
            } else if(i != time.length()) {
                t = time.substring(0,i) + time.substring(i+1);
            }

            getPermutations(t, perm+c, permutations);
        }
    }

    private boolean isValid(String str) {
        String[] time = str.split(":");
        if(time[0].length() == 2 && time[1].length() == 2) {
            return true;
        }
        return false;
    }

    private int findDiff(String str1, String str2) {
        String[] time1 = str1.split(":");
        String[] time2 = str2.split(":");

        String t1 = time1[0] + time1[1];

        String t2 = time2[0] + time2[1];

        return Integer.parseInt(t1) - Integer.parseInt(t2);
    }*/
}
