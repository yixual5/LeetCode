class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += (long)nums[i - 1] + preSum[i - 1];
        }
        return mergeSort(0, preSum.length - 1, preSum, lower, upper);
    }
    
    private int mergeSort(int left, int right, long[] preSum, int lower, int upper) {
        if (right <= left) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(left, mid, preSum, lower, upper) + mergeSort(mid + 1, right, preSum, lower, upper);
        
        //merge
        int low = mid + 1, high = mid + 1;
        int idx = 0;
        int r = mid + 1;
        long[] temp = new long[right - left + 1];
        for (int i = left; i <= mid; i++) {
            while (low <= right && preSum[low] - preSum[i] < lower) low++;
            while (high <= right && preSum[high] - preSum[i] <= upper) high++;
            count += high - low;
            while (r <= right && preSum[r] < preSum[i]) temp[idx++] = preSum[r++];
            temp[idx++] = preSum[i];
        }
        while (r <= right) temp[idx++] = preSum[r++];
        for (int i = left; i <= right; i++) {
            preSum[i] = temp[i - left];
        }
        return count;
    }
    
}