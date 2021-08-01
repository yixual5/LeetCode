class Solution {
    int[] memo = new int[50000];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (profit == null || profit.length == 0) return 0;
        List<int[]> store = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            int[] temp = new int[3];
            temp[0] = startTime[i];
            temp[1] = endTime[i];
            temp[2] = profit[i];
            store.add(temp);
        }
        Collections.sort(store, (a1,a2) -> a1[0] - a2[0]);
        for (int i = 0; i < store.size(); i++) {
            startTime[i] = store.get(i)[0];
        }
        return dfs(0, store, startTime);
    }
    
    private int bsearch(int[] startTime, int end) {
        int left = 0;
        int right = startTime.length - 1;
        int result = startTime.length; //if cannot find it, stop in next
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (startTime[mid] >= end) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private int dfs(int idx, List<int[]> store, int[] startTime) {
        if (idx == store.size()) {
            return 0;
        }
        
        if (memo[idx] != 0) {
            return memo[idx];
        }
        int nextInt = bsearch(startTime, store.get(idx)[1]);
        int mx = Math.max(dfs(nextInt, store, startTime) + store.get(idx)[2],
                         dfs(idx + 1, store, startTime));
        return memo[idx] = mx;
    }
    
}