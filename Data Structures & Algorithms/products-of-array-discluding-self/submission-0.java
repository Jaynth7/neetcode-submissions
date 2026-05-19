class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        

        int [] set1 = new int[nums.length];
        int [] set2 = new int[nums.length];


        set1[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            set1[i] = set1[i - 1] * nums[i - 1];
        }

        set2[nums.length - 1] = 1;

        for(int i = nums.length - 2 ; i >= 0 ; i--){
            set2[i] = set2[i + 1] * nums[i + 1];
        }


        for(int i = 0 ; i < nums.length ; i++){
            output[i] = set1[i] * set2[i] ;
        }

        return output;
    }
}  
