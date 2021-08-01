class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        return helper(c, 0, s.length() - 1, false);
    }
    
    private boolean helper (char[] c, int left, int right, boolean skip) {
        while (left <= right) {
            if (c[left] != c[right]) {
                if (skip) {
                    return false;
                }
                return helper(c, left + 1, right, true) || helper(c, left, right - 1, true);
            }
            right--;
            left++;
        }
        return true;
    }
}