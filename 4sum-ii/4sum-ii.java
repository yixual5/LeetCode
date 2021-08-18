class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                count.put(num1 + num2, count.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        int result = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                result += count.getOrDefault(-(num3 + num4), 0);
            }
        }
        return result;
    }
}

//generalized sol
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap<>();
        int[][] input = {nums1, nums2, nums3, nums4};
        add(count, 0, 0, input);
        return countc(count, input.length / 2, 0, input);
    }
    
    private void add(Map<Integer, Integer> count, int idx, int sum, int[][] input){
        if (idx == input.length / 2) {
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        } else {
            for (int a : input[idx]) {
                add(count, idx + 1, sum + a, input);
            }
        }
    }
    
    private int countc(Map<Integer, Integer> count, int idx, int sum, int[][] input) {
        int cot = 0;
        if (idx == input.length) {
            return count.getOrDefault(sum, 0);
        } else {
            
            for (int a : input[idx]) {
                cot += countc(count, idx + 1, sum - a, input);
            }
        }
        return cot;
    }
}
