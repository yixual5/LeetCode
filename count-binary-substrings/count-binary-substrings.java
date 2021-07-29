// O(N)
class Solution {
    public int countBinarySubstrings(String s) {
        char[] stoc = s.toCharArray();
        int cur = 1;
        int prev = 0;
        int count = 0;
        char prevC = '2';
        for (int i = 1; i < stoc.length; i++) {
            if (stoc[i - 1] != stoc[i]) {
                count += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return count + Math.min(prev, cur);
    }
}
