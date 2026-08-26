class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Store the minimal length of a subarray that is greater than or equal to the target
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        

        for(int right = 0 ; right < nums.length ; right++){
            //Summation Technique
            sum+=nums[right];

            //Whenver the sum exceeds the target or becomes equal to it
            //Check if it's possible to remove the leftmost element and still satisfy the condition
            //Ensures that at the end , we would have the smallest subarray 

            while(sum >= target){
                int currLength = right - left + 1;
                minLength = Math.min(minLength , currLength);
                sum-=nums[left];
                left++;
            }
        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;


    }
}