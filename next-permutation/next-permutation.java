class Solution {
    public void nextPermutation(int[] nums) {
        int prev = -1;
        int idx = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= prev) {
                prev = nums[i];
            } else {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        idx = i;
                        break;
                    }
                }
                break;
            }
            
        }
        int left = idx + 1;
        int right = nums.length - 1;
        while (left <= right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}