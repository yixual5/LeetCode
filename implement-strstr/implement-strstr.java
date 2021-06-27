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

//compare by two pointer
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        
        int j = 0;
        int hlent = haystack.length();
        int nlent = needle.length();
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for (int i = 0; i + nlent <= hlent; i++) {
            while (j < nlent && h[i + j] == n[j]) {
                j++;
                if (j == nlent) return i;
            }
            j = 0;
        }
        return -1;
    }
}
