import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by schaturvedi on 12/27/17.
 */
public class BattleShipGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String t = sc.next();
        String sol = defSolution(n,s,t);
        System.out.println(sol);

    }

    private static String defSolution(int n, String s, String t ) {
        int countSunk =0;
        int countHit =0;

        String[] s1 = s.split(",");
        List<Ship> myShips = new ArrayList<>();
        for(String s2:s1) {
            String [] x = s2.split("\\s+");
            Ship ship = getShip(x);
            myShips.add(ship);
        }
        String []userInputs = t.split("\\s+");
        for(String userInput:userInputs) {
            int shipNumber = whichShip(userInput, myShips);
            if(shipNumber>=0) {
                int count = myShips.get(shipNumber).getCountChecked();
                myShips.get(shipNumber).setCountChecked(++count);
            }
        }


        for(Ship myShip:myShips) {
            if(myShip.getCountChecked()>0 && myShip.getCountChecked()<myShip.getBlocks().size()) {
                countHit++;
            }
            if(myShip.getCountChecked()>0 && myShip.getCountChecked()==myShip.getBlocks().size()) {
                countSunk++;
            }
        }

        System.out.println(countSunk + ", "+countHit);
        return countSunk + ", "+countHit;

    }

    private static Ship getShip(String []str) {
        int x = extractNumbersFromString(str[0]);
        String s = extractLettersFromString(str[0]);
        int currNum = extractNumbersFromString(str[1]);
        String currStr = extractLettersFromString(str[1]);
        Map<String, Integer> myMap = new HashMap<>();

        if(x==currNum) {
            int count=x;
            while(count<=currNum) {
                myMap.put(count+s,0);
                count++;
            }
        }

        if(s.equals(currStr)) {
            Character c = s.charAt(0);
            while(c<=currStr.charAt(0)) {
                myMap.put(c.toString(),0);
                c++;
            }
        }
        Ship myShip = new Ship(myMap, 0);
        return myShip;
    }

    private static int whichShip(String usrInput, List<Ship> ships) {
        int result = -1;
        for(int i=0;i<ships.size();i++) {
            if (ships.get(i).blocks.get(usrInput) !=null){
                return result;
            }
        }
        return result;
    }

    private static int extractNumbersFromString(String s) {
        Pattern p =  Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(s);
        if(m.find()) {
            return Integer.parseInt(m.group());
        }
        return -1;
    }

    private static String extractLettersFromString(String s) {
        return null;
    }
}

class Ship {

    public Ship(){}
    public Ship(Map<String, Integer> blocks, int countChecked) {
        this.blocks = blocks;
        this.countChecked = countChecked;
    }

    public Map<String, Integer> getBlocks() {
        return blocks;
    }

    public void setBlocks(Map<String, Integer> blocks) {
        this.blocks = blocks;
    }

    public int getCountChecked() {
        return countChecked;
    }

    public void setCountChecked(int countChecked) {
        this.countChecked = countChecked;
    }

    Map<String, Integer> blocks;
    int countChecked;

}
