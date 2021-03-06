class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return result;
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int total = p.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] > 0) {
                total--;
            }
            count[s.charAt(right) - 'a']--;
            if (right - left + 1 == p.length()) {
                if (total == 0) {
                    result.add(left);
                }
                if (count[s.charAt(left) - 'a'] >= 0) total++;
                count[s.charAt(left) - 'a']++;
                left++;
            }
            right++;
            
        }
        return result;
    }
}

//simpler method, consider all size p.length() window
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return result;
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int[] count2 = new int[26];
        int right = 0;
        while (right < s.length()) {
            
            count2[s.charAt(right) - 'a']++;
            if (right >= p.length()) {
                count2[s.charAt(right - p.length()) - 'a']--;
            }
            if (Arrays.equals(count, count2)) result.add(right - p.length() + 1);
            right++;
        }
        return result;
    }
}
