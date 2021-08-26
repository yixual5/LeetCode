class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int idle = (freq[freq.length - 1] - 1) * n;
        for (int i = freq.length - 2; i >= 0 && freq[i] > 0; i--) {
            idle -= Math.min(freq[freq.length - 1] - 1, freq[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}