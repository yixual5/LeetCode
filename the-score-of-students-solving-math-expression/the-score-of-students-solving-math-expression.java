class Solution {
    int result = 0;
    boolean flip = false;
    public int scoreOfStudents(String s, int[] answers) {
        if (s == null) return 0;
        int num = s.length() / 2 + 1; //number of digits in s where follow pattern 1+,2*,3*...,n (odd)
        char[] sToC = s.toCharArray();
        Set<Integer>[][] dp = new Set[num][num];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = new HashSet<>();
            dp[i][i].add(sToC[i * 2] - '0');
        }
        
        // basic calculator II
        int prev = 0, cur = 0;
        int express = '+';
        int ans = 0;
        for (char c : sToC) {
            if (Character.isDigit(c)) {
                cur = c - '0';
            } else if (express == '+') {
                ans += prev;
                prev = cur;
                express = c;
            } else if (express == '*') {
                prev *= cur;
                express = c;
            }
        }
        if (express == '+') ans += prev + cur;
        else if (express == '*') ans += prev * cur;

        // all calculation with length 1 finished
        // iterating over size of s from 2 to n
        for (int step = 1; step < num; step++) {
            // each of expression has length step
            for (int start = 0; start < num - step; start++) {
                int end = start + step; //inclusive
                dp[start][end] = new HashSet<>();
                // match the index back to the length of s
                // and find all the cut point where the expression at i is calculated lastly
                // start is digit and start + 1 is + or *
                for (int i = start * 2 + 1; i < end * 2; i += 2) {
                    // notice we calculate all length of expression smaller than step, so we can use dp from
                    // previous result
                    // we iterate all the + or * in the length of step expression
                    for (int left : dp[start][i / 2]) {
                        for (int right: dp[i / 2 + 1][end]) {
                            if (sToC[i] == '+') {
                                if (left + right <= 1000) dp[start][end].add(left + right);
                            } else {
                                if (left * right <= 1000) dp[start][end].add(left * right);
                            }
                        }
                    }
                }
            }
        }
        
        
        int result = 0;
        for (int a : answers) {
            if (a == ans) result += 5;
            else if (dp[0][num - 1].contains(a)) result += 2;
        }
        return result;
        
    }
    
    
}