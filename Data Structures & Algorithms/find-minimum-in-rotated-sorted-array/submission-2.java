class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated at all, the first element is the min
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Inflection point check
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Standard binary search movement
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left]; 
    }
}