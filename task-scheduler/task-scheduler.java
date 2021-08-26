//O(N)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
            if (freq[task - 'A'] == max) {
                maxCount++;
            } else if (freq[task - 'A'] > max) {
                max = freq[task - 'A'];
                maxCount = 1;
            }
        }
        //if maxCount > 1, we need reduce the n by corresponding amount

        int emptySlot = (n - maxCount + 1) * (max - 1);
        int remain = tasks.length - maxCount * max;
        return Math.max(0, emptySlot - remain) + tasks.length;
    }
}
