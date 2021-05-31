class Solution {
    public int longestMountain(int[] arr) {
        int increase = 0;
        int result = 0;
        int decrease = 0;
        int i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i - 1] >= arr[i]){
                i++;
            }
            int str = i;
            while (str < arr.length && arr[str - 1] < arr[str]){
                str++;
            }
            int end = str;
            while (end < arr.length && arr[end - 1] > arr[end]){
                end++;
            }
            if (str > i & end > str) {
                result = Math.max(result, end - i + 1);
            }
            i = end;
        }
        
        return result;
    }
}