// O(S+T)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) count[c]++;
        int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
        int left = 0;
        int right = 0;
        int total = t.length();
        while (right < s.length()) {
            if (count[s.charAt(right)] > 0) {
                total--;
            }
            count[s.charAt(right)]--;
            

            while (left <= right && total == 0) {
                if (right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                if (count[s.charAt(left)] == 0) {
                    total++;
                }
                count[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
    
}
