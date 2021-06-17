// normal backtracking

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, char[]> dtl = new HashMap<>();
        int start = 97;
        for (int i = 2; i <= 9; i++){
            if (i == 7 || i== 9) {
                char[] temp = new char[4];
                temp[0] = (char) start;
                temp[1] = (char) (start + 1);
                temp[2] = (char) (start + 2);
                temp[3] = (char) (start + 3);
                start = start + 4;
                dtl.put((char) (i + '0'), temp);
            } else {
                char[] temp = new char[3];
                temp[0] = (char) start;
                temp[1] = (char) (start + 1);
                temp[2] = (char) (start + 2);
                
                start = start + 3;
                dtl.put((char) (i + '0'), temp);
            }
            
        }
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtracking(digits, result, sb, dtl, 0);
        return result;
    }
    
    private void backtracking (String digits, List<String> result, StringBuffer sb, 
                              Map<Character, char[]> dtl, int idx) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = idx; i < digits.length(); i++) {
            char[] temp = dtl.get(digits.charAt(i));
            for (char c : temp) {
                sb.append(c);
                backtracking(digits, result, sb, dtl, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
    }
}
