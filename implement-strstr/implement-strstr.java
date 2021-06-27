class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int i = 0;
        while (i + needle.length() <= haystack.length()) {
            if (haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}