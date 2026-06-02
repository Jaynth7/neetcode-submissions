class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        //k stays behind i at all times
        //k replaces the duplicate with another unique element 
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    
}