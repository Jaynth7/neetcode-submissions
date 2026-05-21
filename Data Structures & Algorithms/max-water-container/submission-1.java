class Solution {
    public int maxArea(int[] heights) {
        int left = 0 ;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            //area = width * height
            int areaRectangle = Math.min(heights[left], heights[right]) * (right - left);

            maxArea = Math.max(areaRectangle , maxArea);

            if(heights[right] > heights[left]){
                left++;
            }else{
                //this condition execution when h[r] < h[l] and if h[r] == h[l]
                right--;
            }
        }
    return maxArea;
    }


}
