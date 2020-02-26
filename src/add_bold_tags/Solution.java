package add_bold_tags;

public class Solution {

    public static void main(String [] args) {
        //String [] dict = {"abc","123"};
        String [] dict = {"aaa","aab","bc"};
        Solution s = new Solution();
        //String result = s.addBoldTag("abcxyz123", dict);
        String result = s.addBoldTag("aaabbcc", dict);
        System.out.println(result);
    }


    public String addBoldTag(String s, String[] dict) {
        if(s == null || dict.length == 0) {return "";}
        int trackSubstring [] = new int[s.length()];
        int start = -1;
        int end = -1;
        for(String str: dict) {

            do {
                int x = s.indexOf(str, start+1);
                if(x < end && start < s.length() && start != -1) {
                    start = x;
                    trackSubstring[start] = 1;
                    end = Math.max(end, start + str.length() - 1);
                    trackSubstring[start + str.length() - 1] = -1;
                }

            } while(start < s.length() && start >=0);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<trackSubstring.length; i++) {
            if(trackSubstring[i] == 1) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if(trackSubstring[i] == -1) {
                sb.append("</b>");
            }

        }

        return sb.toString();
    }

    /*public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n+1];
        for(String d : dict) {
            int i = -1;
            while((i = s.indexOf(d, i+1)) >= 0) {
                mark[i]++;
                mark[i + d.length()]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == n) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }*/
}
