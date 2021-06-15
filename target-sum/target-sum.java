class Solution {
    private int count;
    
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) return 0;
        this.count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        backtracking(nums, target, 0, sum);
        return this.count;
    }
    
    private void backtracking(int[] nums, int target, int idx, int sum) {
        
        if (sum == target) {
            this.count++;
            if (idx != 0 && nums[idx - 1] != 0) return;
            
        }
        
                
        for (int i = idx; i < nums.length && sum + 2*nums[i] >= target; ++i) {
            nums[i] = - nums[i];
            
            backtracking(nums, target, i + 1, sum + 2*nums[i]);
            nums[i] = - nums[i];
        }
    }
}

\\ cleaner solution, not really backtracking
class Solution {
    private int count;
    
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) return 0;
        this.count = 0;
        
        
        backtracking(nums, target, 0);
        return this.count;
    }
    
    private void backtracking(int[] nums, int target, int idx) {
        
        if (idx == nums.length) {
            if (target == 0) {
                this.count++;
                
            }
            return;
        }
        
        backtracking(nums, target - nums[idx], idx + 1);
        backtracking(nums, target + nums[idx], idx + 1); 
        
    }
}

// 1-d dp solution
class Solution {
    private int count;
    
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) return 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum < target) return 0;
        int[] dp = new int[2*sum + 1];
        dp[sum + nums[0]] = 1;
        dp[sum - nums[0]] += 1;
        
        for (int i = 1; i < nums.length; ++i) {
            int[] next = new int[2*sum + 1];
            
            for (int j = -sum; j <= sum; ++j) {
                if (dp[sum + j] > 0) {
                    next[sum + j + nums[i]] += dp[sum + j];
                    next[sum + j - nums[i]] += dp[sum + j];
                }
                
            }
            dp = next;
        }
        
        return dp[target + sum];
    }
    
    
}
