package canCompleteCircuit;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        int[] gas = {5,1,2,3,4};

        int[] cost = {4,4,1,5,1};
        int result = s.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
    /*public int canCompleteCircuit(int[] gas, int[] cost) {


        for(int i =0; i<gas.length; i++) {
            if(gas[i] >= cost[i]) {
                if(isASolution(gas, cost, i)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private boolean isASolution(int [] gas, int[] cost, int start) {
        int remainingGas = 0;
        for(int i = start; i< gas.length; i++) {
            remainingGas = remainingGas + gas[i] - cost[i];
            if(remainingGas < 0) {
                return false;
            }
        }

        for(int i = 0; i<start; i++) {
            remainingGas = remainingGas + gas[i] - cost[i];
            if(remainingGas < 0) {
                return false;
            }
        }
        if(remainingGas>=0) {
            return true;
        }
        return false;
    }*/
}
