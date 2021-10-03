class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int remain = mean * (n + rolls.length);
        for (int roll : rolls) {
            remain -= roll;
        }
        if (remain > n * 6 || remain < n) return new int[0];
        int[] result = new int[n];
        int initial = remain / n;
        for (int i = 0; i < n; i++) result[i] = initial;
        int left = remain % n;
        for (int i = 0; i < left; i++) result[i] += 1;
        return result;
    }
    
}