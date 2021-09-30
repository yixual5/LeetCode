class Solution {
    public int balancedString(String s) {
        int[] count = new int[26];
        char[] c = s.toCharArray();
        for (char cc : c) {
            count[cc - 'A']++;
        }
        int k = c.length / 4;
        if (count['Q' - 'A'] == k && count['W' - 'A'] == k && count['E' - 'A'] == k && count['R' - 'A'] == k) return 0;
        
        int left = 0;
        int res = c.length + 1;
        for (int right = 0; right < c.length; right++) {
            count[c[right] - 'A']--;
            while (left <= right && count['Q' - 'A'] <= k && count['W' - 'A'] <= k && count['E' - 'A'] <= k && count['R' - 'A'] <= k) {
                res = Math.min(right - left + 1, res);
                count[c[left++] - 'A']++;
            }
        }
        return res;
    }
}