class Solution {

    public static void reverse(int nums[] , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        //Ensuring that k stays in bound
        k =  k % nums.length;

        //Basically , there is a trick
        //Reverse the whole array
        reverse(nums , 0 , nums.length - 1);
        //Reverse the array from 0 to k - 1
        reverse(nums , 0 , k - 1);
        //Reverse the array from k till n - 1
        reverse(nums , k , nums.length - 1);
    }
}