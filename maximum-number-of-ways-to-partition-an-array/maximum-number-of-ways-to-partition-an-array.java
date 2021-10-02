class Solution {
    public int waysToPartition(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return 0;
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (long) nums[i];
        }
        Map<Long, Integer> right = new HashMap<>();
        Map<Long, Integer> left = new HashMap<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            long diff = 2 * prefixSum[i] - prefixSum[nums.length - 1];
            right.put(diff, right.getOrDefault(diff, 0) + 1);
        }
        
        int count = right.getOrDefault((long) 0, 0);
        
        for (int i = 0; i < nums.length; i++) {
            int countNew = 0;
            long dif = (long) k - (long) nums[i];
            
            long diff = 2 * prefixSum[i] - prefixSum[nums.length - 1];

            countNew += right.getOrDefault(-dif, 0);
            countNew += left.getOrDefault(dif, 0);

            count = Math.max(count, countNew);
            if (right.getOrDefault(diff, 0) > 0) {
                right.put(diff, right.get(diff) - 1);
                left.put(diff, left.getOrDefault(diff, 0) + 1);
            }
        }
        return count;
    }
}