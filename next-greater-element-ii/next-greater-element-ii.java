class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                result[s.pop()] = nums[i];
            }
            s.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                result[s.pop()] = nums[i];
            }
        }
        while (!s.isEmpty()) result[s.pop()] = -1;
        
        return result;
    }
}