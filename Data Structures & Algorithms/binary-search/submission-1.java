class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int m = 0;

        while(left <= right){
            m = Math.floorDiv(right + left , 2);
            if (nums[m] > target){
                right = m - 1;
            }else if(nums[m] < target){
                left = m + 1;
            }else {
                return m;
            }
        }


        return -1;
    }
}
