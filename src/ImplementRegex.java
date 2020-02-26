import java.util.Scanner;

/**
 * Created by schaturvedi on 11/10/17.
 */
public class ImplementRegex {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        System.out.println("Enter the pattern");
        String pattern = sc.next();

        System.out.println("Output: "+ isAMatch(str, pattern));
    }

    static boolean isAMatch(String str, String pattern) {
        if(str == null || pattern == null) {
            return false;
        }

        boolean arr[][] = new boolean[str.length()+1][pattern.length()+1];
        arr[0][0] = true;

        //initialize the first row
        for(int i =1; i< arr[0].length; i++) {
            arr[0][i] = false;
        }

        for(int i = 1; i< arr.length; i++) {
            for(int j = 1; j<arr[0].length; j++) {
                //case 1: if str[i] == str[j] or pattern[j] = ?
                Character c2 = str.charAt(i-1);
                Character c4 = pattern.charAt(j-1);
                if( str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    arr[i][j] = arr[i-1][j-1];
                }
                else {
                    //case 2:  pattern[j] = *
                    if(pattern.charAt(j-1) == '*') {
                        arr[i][j] = arr[i-1][j] || arr[i][j-1];
                    }
                    else {
                        //case 3: str[i] != pattern[j]
                        arr[i][j] = false;
                    }
                }
            }
        }

        for (int i =0; i<arr.length; i++) {
            System.out.println();
            for(int j=0; j<arr[0].length; j++) {System.out.print(arr[i][j]);
            }
        }
        return arr[str.length()][pattern.length()];
    }
}
