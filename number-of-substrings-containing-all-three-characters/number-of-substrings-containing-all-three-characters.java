class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            count[idx]++;
            while (count[0] > 0 & count[1] > 0 && count[2] > 0) {
                count[s.charAt(left++) - 'a']--;
            }
            res += left;
        }
        return res;
    }
}