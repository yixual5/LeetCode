class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        // change list to set
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        
        backtracking(result, nums, 0);
        return new ArrayList<>(result);
    }
    //
    private void backtracking(Set<List<Integer>> result, int[] nums, int idx){
        if (idx == nums.length) {
            LinkedList<Integer> t = new LinkedList<>();
            for (int num : nums) {
                t.add(num);
            }
            result.add(t);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            this.swap(nums, idx, i);
            backtracking(result, nums, idx + 1); //fix the first one
            this.swap(nums, idx, i); //backtrack
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




// use hashmap to store the count of each integer that not unique, reduce the runtime to O(size of hashmap!) (worst runtime is as same as the previous soultion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        for (int num: nums) {
            count.compute(num, (k,v) -> v == null ? 1 : v + 1);
        }
        backtracking(nums.length, count, result, cur);
        return result;
    }
    
    private void backtracking(int numlength, Map<Integer, Integer> count,
                        List<List<Integer>> result, LinkedList<Integer> cur) {
        if (cur.size() == numlength) {
            result.add((LinkedList) cur.clone());
            return;
        }
        
        for (Map.Entry<Integer, Integer> et: count.entrySet()) {
            if (et.getValue() == 0) continue;
            et.setValue(et.getValue() - 1);
            cur.add(et.getKey());
            backtracking(numlength, count, result, cur);
            et.setValue(et.getValue() + 1);
            cur.removeLast();
        }
    }
    
}
