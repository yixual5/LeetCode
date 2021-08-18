class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (target - numbers[left] - numbers[right] == 0) return new int[]{left + 1, right + 1};
            else if (target - numbers[left] - numbers[right] > 0) left++;
            else right--;
        }
        return new int[]{0, 0};
    }
}

//O(log(n)) average
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = numbers[left] + numbers[right];
            if (target == sum) return new int[]{left + 1, right + 1};
            else if (target < sum) right = (numbers[left] + numbers[mid] > target) ? mid - 1 : right - 1;
            else left = (numbers[right] + numbers[mid] < target) ? mid + 1 : left + 1;
        }
        return new int[]{0, 0};
    }
}
