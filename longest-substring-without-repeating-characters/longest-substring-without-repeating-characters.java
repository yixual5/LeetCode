class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int res = 0;
        if (s == null || s.length() == 0) return 0;
        int right;
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (count.getOrDefault(c, 0) != 0) {
                res = Math.max(right - left, res);
                char l = s.charAt(left++);
                count.put(l, count.get(l) - 1);
            }
            count.put(c, 1);
            
        }
        return Math.max(res, right - left);
    }
}