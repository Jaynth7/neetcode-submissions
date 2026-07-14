class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        //Templates 
        int candidate1 = -1 ;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;



        //Iterating through the array
        //If a candidate reappears  , increase their count
        //If count of candidate 1 or 2 is zero , reassign candidates and reset the count to 1
        //If neither of the candidates reappear , decrement their count - The current element is not of them

        for(int num : nums){
            if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = num;
                count2 = 1; 
            }else{
                count1--;
                count2--;
            }
        }

        //Reinitiate count 1 and 2 to 0
        //Bcz by the end of the array the elements with the most count would be the candidates

        count1 = count2 = 0;

        for(int num : nums){
            if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }
        }


        if(count1 > n / 3){
            result.add(candidate1);
        }

        if(count2 > n / 3){
            result.add(candidate2);
        }


        return result;

       

    }
}