class Solution {
    public boolean stoneGameIX(int[] stones) {
        if (stones == null || stones.length == 1) return false;
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        int one = count[1] - 1;
        int two = count[2];
        // start with 1
        while (one > 0 && two > 0) {
            one--;
            two--;
        }
        // start with 2
        count[2]--;
        while (count[1] > 0 && count[2] > 0) {
            count[2]--;
            count[1]--;
        }
        
        if (count[0] % 2 != 0) {
        
            if (one > 1) return true;
            if (count[2] > 1) return true;
        } else {
            // start with one left only two
            if (one == 0 && two >= 1) return true;
            // start with two only left one
            if (count[1] >= 1 && count[2] == 0) return true;
        }
        return false;
    }
}