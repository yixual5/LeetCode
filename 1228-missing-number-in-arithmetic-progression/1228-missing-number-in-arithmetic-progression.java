class Solution {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / (arr.length);
        if (diff < 0) {
            int count = arr.length - 1;
            for (int i = arr[arr.length - 1]; i <= arr[0] ; i -= diff) if (i != arr[count--]) return i;
        } else if (diff == 0) {
            return arr[0];
        } else {
            int count = 0;
            for (int i = arr[0]; i <= arr[arr.length - 1]; i += diff) if (i != arr[count++]) return i;
        }
        
        return -1;
    }
}