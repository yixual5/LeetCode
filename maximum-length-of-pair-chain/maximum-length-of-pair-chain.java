// o(n^2)
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] memo = new int[pairs.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j< pairs.length; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
        }
        int result = 0;
        for (int i : memo) result = Math.max(i, result);
        return result;
    }
}

//greedy algorithm, chain the smallest endTime, which can guarantee more chain in future
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int cur = -1001;
        for (int[] pair : pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }
}
