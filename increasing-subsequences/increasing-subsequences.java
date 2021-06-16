class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        backtracking(0, nums, result, cur);
        
        return result;
    }
    // change linkedlist to arraylist for O(1) get
    private void backtracking(int idx, int[] nums, List<List<Integer>> result,       LinkedList<Integer> cur) {
        
        if (idx > nums.length) return;
        
        
        if (cur.size() >= 2) {
            result.add((LinkedList) cur.clone());
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (cur.size() > 0 && cur.get(cur.size() - 1) > nums[i]) continue; 
            visited.add(nums[i]);
            cur.add(nums[i]);
            backtracking(i + 1, nums, result, cur);
            cur.removeLast();
        }
    }
}
