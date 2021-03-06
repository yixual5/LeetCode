class Solution {
    // take some time to think about how to skip the duplicate subset
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        int idx = 0;
        Arrays.sort(nums);
        backtracking(nums, result, cur, idx);
        return result;
    }
    
    private void backtracking (int[] nums, List<List<Integer>> result, LinkedList<Integer> cur, int idx) {
        result.add((LinkedList) cur.clone());
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; ++i) {
            // if we alreadt not consider i -1, we should not consider i (same value) in the same level. which needs i > idx
            if (i > idx && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backtracking(nums, result, cur, i + 1);
            cur.removeLast();
        }
    }
}
