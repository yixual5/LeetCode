class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int first = search(nums, target, true);
        int last = search(nums, target, false);
        return new int[]{first, last};
    }
    
    private int search(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right- left) / 2;
            if (nums[mid] == target) {
                if (first) {
                    if (mid == left || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == right || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}