class Solution {
    public int minSteps(String s, String t) {
        if (s.length() != t.length()) return -1;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] count = new int[26];
        for (char c : ss) {
            count[c - 'a']++;
        }
        for (char c : tt) {
            count[c - 'a']--;
        }
        int res = 0;
        for (int ct : count) {
            res += ct > 0 ? ct : 0;
        }
        return res;
    } 
}