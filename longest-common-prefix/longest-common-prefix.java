class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuffer sb = new StringBuffer();
        int idx = 0;
        while (true) {
            if (strs[0].length() - 1 < idx) return sb.toString();
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() - 1 < idx) return sb.toString();
                if (strs[i].charAt(idx) != strs[i - 1].charAt(idx)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(idx++));
        }
        
    }
}