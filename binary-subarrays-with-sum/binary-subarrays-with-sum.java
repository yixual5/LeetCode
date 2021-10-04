class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int result = 0;
        int left = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > goal && i > left) {
                count -= nums[left++];
                prefix = 0;
            }
            
            if (count == goal) {
                while (left < i && nums[left] == 0) {
                    left++;
                    prefix++;
                }
                result += prefix + 1;
            }
            
        }
        
        return result;
    }
}