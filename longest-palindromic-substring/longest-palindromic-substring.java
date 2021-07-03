// search from center, O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        String result = "";
        int bestL = 0;
        for (int mid = 0; mid < s.length(); mid++) {
            for (int j = 0; mid - j >= 0 && mid + j < s.length(); j++) {
                if (s.charAt(mid - j) != s.charAt(mid + j)) break;
                String sb = s.substring(mid - j, mid + j + 1);
                int l = sb.length();
                if ( l > bestL) {
                    bestL = l;
                    result = sb;
                }
            }
        }
        for (int mid = 0; mid < s.length(); mid++) {
            for (int j = 1; mid - j + 1 >= 0 && mid + j < s.length(); j++) {
                if (s.charAt(mid - j + 1) != s.charAt(mid + j)) break;
                String sb = s.substring(mid - j + 1, mid + j + 1);
                int l = sb.length();
                if ( l > bestL) {
                    bestL = l;
                    result = sb;
                }
            }
        }
        return result;
    }
    
    
}

//dp solution
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        String result = "";
        int bestL = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                boolean temp = s.charAt(i) == s.charAt(j);
                dp[j][i] = i - j + 1 > 2 ? temp && dp[j + 1][i - 1]: temp;
                int l = i - j + 1;
                if (dp[j][i] && l > bestL) {
                    bestL = l;
                    result = s.substring(j, i + 1);
                }
            }
        }
        
        return result;
    }
    
    
}
