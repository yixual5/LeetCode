// o(n^2)
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

//O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        int sum = 0;
        count.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += count.getOrDefault(sum - k, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
