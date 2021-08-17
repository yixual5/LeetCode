// if total > 0, at some point we must have a positive cur so that we can balance the prev negativ, O(N)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                idx = i + 1;
            }
        }
        return total < 0 ? -1 : idx;
    }
}

// same idea
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < min) {
                idx = i;
                min = total;
            }
        }
        return total < 0 ? -1 : (idx + 1) % gas.length;
    }
}
