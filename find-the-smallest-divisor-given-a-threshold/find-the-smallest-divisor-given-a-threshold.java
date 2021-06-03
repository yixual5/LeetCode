class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums == null || nums.length == 0) return -1;
        int mx = 0;
        for (int i : nums) {
            mx = Math.max(mx, i);
        }
        int left = 1;
        int right = mx;
        int mid = 0;
        int ans = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (sumofdivision(nums, mid) <= threshold) {
                ans = mid;
                right = mid - 1; //decrease to find smaller divisor
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    private int sumofdivision(int[] nums, int divisor) {
        int sum = 0;
        for (int i : nums) {
            sum += (i + divisor - 1) / divisor;
        }
        return sum;
    }
}
