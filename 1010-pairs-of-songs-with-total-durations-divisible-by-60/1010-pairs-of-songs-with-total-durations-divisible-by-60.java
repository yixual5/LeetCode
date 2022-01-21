class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int i : time) {
            res += i % 60 == 0 ? count[0] : count[60 - i % 60];
            count[i % 60]++;
        }
        return res;
    }
}