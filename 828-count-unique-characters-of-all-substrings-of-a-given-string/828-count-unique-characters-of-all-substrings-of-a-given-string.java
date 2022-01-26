class Solution {
    public int uniqueLetterString(String s) {
        int[][] lastPosition = new int[26][2];
        for(int[] i : lastPosition) i[0] = -1;
        lastPosition[s.charAt(0) - 'A'][0] = 0;
        lastPosition[s.charAt(0) - 'A'][1] = 1;
        int res = 1;
        int sum = 1;
        for (int i = 1; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            res = res - lastPosition[idx][1] + (i - lastPosition[idx][0]);
            lastPosition[idx][1] = i - lastPosition[idx][0];
            lastPosition[idx][0] = i;
            sum += res;
        }
        return sum;
    }
}