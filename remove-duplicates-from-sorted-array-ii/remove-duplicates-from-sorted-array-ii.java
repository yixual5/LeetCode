class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <=2) return nums.length;
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            nums[i] = nums[j];
            if (nums[i] != nums[i - 2]) i++;
        }
        return i;
    }
}