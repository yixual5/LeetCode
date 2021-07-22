// naive approach 20 mins O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mx = nums[0];
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (sum >= 0 && i < nums.length) {
                sum += nums[i++];
                mx = Math.max(mx, sum);
            }
            i--;
            sum = 0;
        }
        return mx;
    }
}

//cleaner
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mx = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            mx = Math.max(mx, sum);
        }
        return mx;
    }
}

//divide and conquer O(nlog(n))
class Solution {
    int[] nums;
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    
    private int helper(int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftmax = helper(left, mid - 1);
        int rightmax = helper(mid + 1, right);
        int sum = 0;
        int mxl = 0;
        for (int i = mid - 1; i >= 0; i--) {
            sum += nums[i];
            mxl = Math.max(mxl, sum);
        }
        sum = 0;
        int mxr = 0;
        for (int i = mid + 1; i < nums.length; i++) {
            sum += nums[i];
            mxr = Math.max(mxr, sum);
        }
        int interme = Math.max(nums[mid] + mxr + mxl, leftmax);
        return Math.max(interme, rightmax);
    }
}
