class Solution {
    public int maxArea(int[] height) {
        int right = height.length - 1;
        int area = 0;
        int i = 0;
        while (i < right) {
            int width = right - i;
            int minh = Math.min(height[i],height[right]);
            area = Math.max(area, minh * width);
            while ( i < right && height[i] <= minh) {
                //area = Math.max(area, height[i] * width);
                i++;
            }
            while (i < right && minh >= height[right]) {
                //area = Math.max(area, height[right] * width);
                right--;
            }
        }
        return area;
    }
    
}