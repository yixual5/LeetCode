class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int reverseHalf = 0;
        while (x > reverseHalf) {
            reverseHalf = x % 10 + reverseHalf * 10;
            x /= 10;
        }
        //length is odd we need get rid of the middle value
        return x == reverseHalf || x == reverseHalf / 10;
    }
}