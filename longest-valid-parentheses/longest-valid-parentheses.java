class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int mx = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2 < 0 ? 0 : i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - dp[i - 1] - 2 >= 0 ? i - dp[i - 1] - 2 : 0] + dp[i - 1] + 2;
                }
                mx = Math.max(mx, dp[i]);
                
            }
        }
        return mx == Integer.MIN_VALUE ? 0 : mx;
    } 
}

//stack
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int mx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else mx = Math.max(i - stack.peek(), mx);
            }
        }
        return mx;
    } 
}

//dp
class Solution {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            int sender = transaction[0];
            int recevier = transaction[1];
            int amount = transaction[2];
            map.put(sender, map.getOrDefault(sender, 0) - amount);
            map.put(recevier, map.getOrDefault(recevier, 0) + amount);
        }
        //dp[mask] be the maximum number of min_sets can be formed by the elements in set[mask].
        //ans = N - M
        List<Integer> debt = map.values().stream().filter(v -> v != 0).collect(Collectors.toList());
        int[] dp = new int[1 << debt.size()];
        int[] sum = new int[1 << debt.size()];
        for (int i = 0; i < dp.length; i++) {
            int setBit = 1;
            for (int j = 0; j < debt.size(); j++) {
                if ((i & setBit) == 0) {
                    int nxt = i | setBit;
                    sum[nxt] = sum[i] + debt.get(j);
                    if (sum[nxt] == 0) {
                        dp[nxt] = Math.max(dp[i] + 1, dp[nxt]);
                    } else {
                        dp[nxt] = Math.max(dp[i], dp[nxt]);
                    }
                }
                setBit <<= 1;
            }
        }
        return debt.size() - dp[dp.length - 1];
    }
    
}
