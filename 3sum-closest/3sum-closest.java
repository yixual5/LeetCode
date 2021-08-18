//O(N^2)
class Solution {
    int diff = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(i + 1, nums, target - nums[i]);
            if (diff == 0) return target;
        }
        return target - diff;
    }
    
    private void twoSum(int idx, int[] nums, int target) {
        int left = idx;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                diff = 0;
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
            if (Math.abs(diff) > Math.abs(target - sum)) diff = target - sum;
        }
    }
}
