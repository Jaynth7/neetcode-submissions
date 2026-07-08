class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k+=1;
            }
            //The condition is that whenever the element does not equal to val then we just keep on iterating
            //Have to bring all elements except val to the front of the array 
            //K stays as 0 unless an element needs to be moved towards the front (Replace)
        }
        return k;
    }
}