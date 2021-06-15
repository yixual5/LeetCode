// the simplest solution
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int idx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= idx) idx = i;
        }
        
        
        return idx == 0;
    }
}

// backtracking that i first came out, TLE
class Solution {
    public boolean canJump(int[] nums) {
        
        return dfs(0, nums);
    }
    
    private boolean dfs(int idx, int[] nums) {
        if (idx == nums.length - 1) return true;
        int nextPos = Math.min(idx + nums[idx], nums.length - 1);
        
        
        for (int j = nextPos; j > idx; j--) {
            
            if (dfs(j, nums)) return true;
        }
        return false;
    }
}

// backtracking top-down dp
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1; // 1 is true 2 is false 0 is unknown
        return dfs(0, nums, dp);
    }
    
    private boolean dfs(int idx, int[] nums, int[] dp) {
        if (dp[idx] != 0){
            return dp[idx] == 1 ? true : false;
        }
        
        int nextPos = Math.min(idx + nums[idx], nums.length - 1);
        
        
        for (int j = idx + 1; j <= nextPos; j++) {
            
            if (dfs(j, nums, dp)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 2;
        return false;
    }
}

// button-up dp (no recursion)

class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1; // 1 is true 0 is false
        for (int i = nums.length - 2; i >= 0; --i) {
            int nextPos = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= nextPos; j++) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1;
    }
}
        
