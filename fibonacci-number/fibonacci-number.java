// recursive
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        return fib(n - 1) + fib(n - 2);
    }
}

// top-down recursive dp
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        return buttonup(dp, n);
        
    }
    
    private int buttonup (int[] dp, int n) {
        if (dp[n] != 0 || n == 0) {
            return dp[n];
        }
        dp[n] = buttonup(dp, n - 1) + buttonup(dp, n - 2);
        return dp[n];
    }
}

// bottun up dp
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        buttonup(dp, n);
        return dp[n];
    }
    
    private void buttonup (int[] dp, int n) {
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}

// bottun up dp O(1) space
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        
        int prev1 = 0;
        int prev2 = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
    

}
