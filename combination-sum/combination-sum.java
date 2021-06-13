class Solution {
    // naive approach
    private List<List<Integer>> result;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.candidates = candidates;
        if (candidates == null) return this.result;
        count(new LinkedList<Integer>(), 0, target, 0);
        return result;
    }
    
    private List<Integer> count(LinkedList<Integer> cur, int sum, int target, int idx) {
        
        if (sum == target) return cur;
        if (sum > target) return null;
        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            
            if (count(cur, sum + candidates[i], target, i) != null) {
                result.add((LinkedList) cur.clone());
            }
            cur.removeLast();
        }
        return null; // never reach here because we can also keep add some values
    }
}
