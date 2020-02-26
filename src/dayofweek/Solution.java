package dayofweek;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        //String result = s.dayOfTheWeek(31, 8, 2019);
        String result = s.dayOfTheWeek(18,7, 1999);
        System.out.println(result);
    }

    int daysMonth[]  = {31,28,31,30,31,30,31,31,30,31,30,31};
    String[] weekDays = { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    public String dayOfTheWeek(int day, int month, int year) {
        if(day == 1 && month == 1 && year == 1971) {
            return "Friday";

        }

        int years = year - 1971;
        int days = 365 * years;
        for(int i= 1971; i< year; i++) {
            if(i%4 == 0 && (i %100 != 0 ||  i%400 == 0)) {
                days++;
            }
        }

        for(int i = 1; i<month-1; i++) {
            days = days + daysMonth[i];
        }

        if(year%4 == 0 && (year %100 != 0 ||  year%400 == 0)) {
            days++;
        }

        days = days + day;

        int num = days % 7;
        return weekDays[num];

    }


}
