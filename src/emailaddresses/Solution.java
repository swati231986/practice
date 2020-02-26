package emailaddresses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String [] args) {
        String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com", "anc@leetcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
    /*public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet();
        int numUniqueEmails = 0;
        for(String email: emails) {
            String [] splitedEmail = email.split("@");
            String emailIdOrigin = splitedEmail[0];
            String domainName = splitedEmail[1];
            String emailId = emailIdOrigin.split("\\+")[0].replace(".","");
            String finalEmail = emailId+"@"+domainName;
            if(!emailSet.contains(finalEmail)) {
                ++numUniqueEmails;
                emailSet.add(finalEmail);
            }
        }
        return numUniqueEmails;
    }*/

    public static int numUniqueEmails(String [] emails) {

        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String rest = email.substring(i);
            seen.add(rest);
        }
        return seen.size();
    }
}
