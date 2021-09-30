class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        if (s == null || s.length() == 0) return 0;
        char[] sToC = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        int mx = 0;
        int left = 0;
        for (int right = 0; right < sToC.length; right++) {
            char c = sToC[right];
            if (count.getOrDefault(c, 0) == 0) k--;
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (k < 0) {
                if (count.get(sToC[left]) == 1) k++;
                count.put(sToC[left], count.get(sToC[left]) - 1);
                left++;
            }
            mx = Math.max(right - left + 1, mx);
        }
        return mx;
    }
}