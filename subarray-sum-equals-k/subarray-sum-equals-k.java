class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int[] count = new int[nums.length];
        count[0] = nums[0];
        int result = count[0] == k ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            count[i] = count[i - 1] + nums[i];
            if (count[i] == k) result++;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < count.length; j++) {
                count[j] = count[j] - nums[i - 1];
                if (count[j] == k) result++;
            }
        }
        return result;
    }
}