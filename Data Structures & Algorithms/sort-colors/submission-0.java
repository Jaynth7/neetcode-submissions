class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        //Low's responsibiliy is to hold a boundary. Before low , all elements are 0.
        int mid = 0;
        //Mid is used to swap the elements 0 , 1  and 2 . It's the scanner , responsible for respresenting the mid section of 1s
        //Moves left to right only . Reason : It knows what it has passed
        int high = nums.length - 1;
        //High's responsibiliy is to hold a boundary. Aftrt high , all elements are 2.


        while(mid <= high){
            //Whenver they meet , it indicates that the array is sorted

            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                //If mid == 2


                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}