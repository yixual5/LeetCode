class Solution {
    List<String> result = new ArrayList<>();
    int n = 0;
    
    public List<String> generateParenthesis(int n) {
        if (n == 0) return result;
        this.n = n;
        StringBuffer sb = new StringBuffer();
        backtracking(sb, n, n);
        return result;
    }
    
    private void backtracking(StringBuffer sb, int open, int close) {
        if (close == 0 && open == 0) {
            result.add(sb.toString());
            return;
        }
        if (open > 0) {
            sb.append('(');
            backtracking(sb, open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close > open) {
            sb.append(')');
            backtracking(sb, open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}