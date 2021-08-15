class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return "";
        int[] count = new int[52];
        for (char c : t.toCharArray()) count[getIdx(c)]++;
        int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
        int left = 0;
        int right = 0;
        int total = t.length();
        while (right < s.length()) {
            if (count[getIdx(s.charAt(right))] > 0) {
                total--;
            }
            count[getIdx(s.charAt(right))]--;
            

            while (left <= right && total == 0) {
                if (right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                if (count[getIdx(s.charAt(left))] == 0) {
                    total++;
                }
                count[getIdx(s.charAt(left))]++;
                left++;
            }
            right++;
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
    
    private int getIdx(char c) {
        if (c - 'A' < 26) return c - 'A';
        return (c - 'a') + 26;
    }
}