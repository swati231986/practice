package task_scheduler;

import java.util.Arrays;

public class Solution {

    public static void main(String [] args) {
        char[] tasks = {'A','A','A','A','A','A','A','A','A','B','B','C','C','C'};
        //char[] tasks = {'A','A','A','B','B','B'};
        Solution s = new Solution();
        int result = s.leastInterval(tasks,3);
        System.out.println(result);
    }
    /*public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0) {return 0;}

        int [] tasksNum = new int[26];
        for(char c:tasks) {
            tasksNum[c-'A']++;
        }

        Arrays.sort(tasksNum);
        int intervals = 0;

        while(tasksNum[25] >0) {

            int i =0;
            while(i <=n ) {
                if(tasksNum[25] ==0) {
                    break;
                }
                if(i<26 && tasksNum[25-i] >0) {
                    tasksNum[25-i]--;

                }
                i++;

                intervals++;
            }
            Arrays.sort(tasksNum);
        }

        return intervals;
    }*/


    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

   /* public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }*/
}
