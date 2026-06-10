class Solution {
    static int searchInsert(int nums[], int k) {  
        int left = 0, right =nums.length - 1;
        while(left <= right) {  
            int mid = left + (right - left) / 2;  
            
            // if k is found at mid
            if(nums[mid] == k) {  
                return mid;  
            }  

            // if k is smaller, search in left half
            else if(nums[mid] > k) {  
                right = mid - 1;  
            }  

            // if k is larger, search in right half
            else {  
                left = mid + 1;  
            }  
        }  

        // if k is not found, return insert position
        return left;  
    }  
 
}