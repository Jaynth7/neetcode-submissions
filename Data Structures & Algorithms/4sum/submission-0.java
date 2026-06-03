class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Solution without recursion
        List<List<Integer>> res = new ArrayList<>();


        Arrays.sort(nums);

        //array is sorted before hand to make easier to identify duplicate elements

        int n = nums.length;

        //i's limit is n - 3 because at that position , there always be 2 elements remmaing to check
        //which is j's element and left pointer's or right pointer's element
        for(int i = 0 ; i < n - 3 ;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            //j should always be ahead of i
            for(int j = i + 1 ; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;


                int left = j + 1;
                int right = n - 1;
                //
                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i]  , nums[j] , nums[left] , nums[right] ));
                    
                        //removing duplicates from any list by skipping them
                        //when the element appears again in front of left or before right , it is considered as an duplicate bcz this element might have been already added
                        //we choose to Skip adjacent identical values to prevent evaluating the same numeric combination twice


                        while(left < right && nums[left] == nums[left + 1])left++;
                        while(left < right && nums[right] == nums[right - 1])right--;

                        left++;
                        right--;

                    }else if (sum > target){
                        right--;
                    }else{
                        left++;
                    }
                } 
            }
        }


        return res;


    }
}