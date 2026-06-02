class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length ;
        
        int count = 0;
        int candidate = 0;

         for(int i = 0 ; i < n ; i++){
               if(count == 0){
                 candidate = nums[i];
                }

              count += (candidate==nums[i]? 1 : -1);
        }

        return candidate;


        
    }
}


// 
/*
    HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ;i++){
            map.put(nums[i] , map.getOrDefault( nums[i] , 0) + 1);
            if(map.get(nums[i]) > n /2){
                return nums[i];
            }
        }


        return -1;




    int count = 0;
    int candidate = 0

    for(int i = 0 ; i < n ; i++){
        if(count == 0){
            candidate = nums[i];
        }

        count += (candidate==nums[i]? 1 : -1);
    }

    return candidate

*/