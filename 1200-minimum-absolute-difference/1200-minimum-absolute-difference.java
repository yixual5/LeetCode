class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (diff > arr[i] - arr[i - 1]) {
                diff = arr[i] - arr[i - 1];
                res = new LinkedList<>();
                res.add(Arrays.asList(new Integer[]{arr[i - 1], arr[i]}));
            } else if (diff == arr[i] - arr[i - 1]) res.add(Arrays.asList(new Integer[]{arr[i - 1], arr[i]}));
        }
        return res;
    }
}