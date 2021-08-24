class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (helper(s, word)) count++;
        }
        return count;
    }
    
    private boolean helper(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            char a = s.charAt(i);
            char b = word.charAt(j);
            if (a != b) return false;
            int starti = i;
            int startj = j;
            while (i < s.length() && s.charAt(i) == a) i++;
            while (j < word.length() && word.charAt(j) == b) j++;
            int wordCount = j - startj;
            int sCount = i - starti;
            if (wordCount > sCount || (wordCount == 1 && sCount == 2)) return false;
        }
        return i == s.length() && j == word.length();
    }
}