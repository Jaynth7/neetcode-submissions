class Solution {
    //Solution - Fast and Slow pointers , Implementing the Floyd's Algo(Confusing AF)
    //Basically move the fast and slow pointers till they meet
    //Create another slow pointer from the starting node 
    //Wherever the initial and subsequent slow pointer meet would be the duplicate element
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            //This is where the concept of LL is combined
            fast = nums[nums[fast]];
            if(fast == slow){
                break;
            }
        }

        int slow2 = 0;
        //Theoritically proven
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2){
                return slow;
            }

        }
    }
}
