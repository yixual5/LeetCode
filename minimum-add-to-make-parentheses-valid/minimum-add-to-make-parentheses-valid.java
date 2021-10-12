class Solution {
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count == -1) {
                res++;
                count++;
            }
        }
        return res + count;
    }
}